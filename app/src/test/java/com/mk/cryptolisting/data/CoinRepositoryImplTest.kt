package com.mk.cryptolisting.data

import com.mk.cryptolisting.data.local.CoinDao
import com.mk.cryptolisting.data.remote.CoinApi
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import com.google.common.truth.Truth.assertThat
import com.mk.cryptolisting.data.local.entity.CoinEntity
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import com.mk.cryptolisting.data.remote.*

class CoinRepositoryImplTest {
    private lateinit var repository: CoinRepositoryImpl
    private lateinit var webserver: MockWebServer
    private lateinit var coinDao: CoinDao

    @Before
    fun setup() {
        webserver = MockWebServer()
        coinDao = CoinDaoFake()
        val okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        val api = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(webserver.url("/")).build().create(CoinApi::class.java)
        repository = CoinRepositoryImpl(
            api = api,
            dao = coinDao
        )
    }

    @After
    fun tearDown() {
        webserver.shutdown()
    }

    @Test
    fun `get all coins from remote, valid response, returns success and saves to db`() = runBlocking {
        webserver.enqueue(MockResponse().setBody(validGetCoins))
        val result = repository.getAllCoins(true)
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrDefault(listOf()).size).isEqualTo(10)
        assertThat(coinDao.getCoins().size).isEqualTo(10)
    }

    @Test
    fun `get all coins from remote, malformed response, returns failure and doesnt save to db`() = runBlocking {
        webserver.enqueue(MockResponse().setBody(malformedGetCoins))
        val result = repository.getAllCoins(true)
        assertThat(result.isFailure).isTrue()
        assertThat(result.getOrDefault(listOf()).size).isEqualTo(0)
        assertThat(coinDao.getCoins().size).isEqualTo(0)
    }

    @Test
    fun `force get all coins from local, empty local, returns from remote with success and saves to db`() = runBlocking {
        webserver.enqueue(MockResponse().setBody(validGetCoins))
        val result = repository.getAllCoins(false)
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrDefault(listOf()).size).isEqualTo(10)
        assertThat(coinDao.getCoins().size).isEqualTo(10)
    }

    @Test
    fun `force get all coins from local, valid local, returns from remote with success and saves to db`() = runBlocking {
        webserver.enqueue(MockResponse().setBody(validGetCoins))
        coinDao.insertCoin(CoinEntity(name = "", abbreviation = "", price = 0.0, icon = ""))
        val result = repository.getAllCoins(false)
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrDefault(listOf()).size).isEqualTo(1)
        assertThat(coinDao.getCoins().size).isEqualTo(1)
    }

    @Test
    fun `get coin detail, valid response, returns success`() = runBlocking {
        webserver.enqueue(MockResponse().setBody(validCoinDetails))
        val result = repository.getCoinDetail("")
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrDefault(listOf()).size).isEqualTo(11)
    }

    @Test
    fun `get coin detail, malformed response, returns failure`() = runBlocking {
        webserver.enqueue(MockResponse().setBody(malformedCoinDetails))
        val result = repository.getCoinDetail("")
        assertThat(result.isFailure).isTrue()
        assertThat(result.getOrDefault(listOf()).size).isEqualTo(0)
    }
}