package com.mk.cryptolisting.data.remote

import com.mk.cryptolisting.data.remote.dto.CoinListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {
    companion object {
        const val BASE_URL = "https://min-api.cryptocompare.com/"

        //Should be inside gradle.properties. But not doing it so you don't have to create a new one
        const val API_KEY = "c384cc7ed82ab3935bb9a31a863b95d40e4dc89f83850d302a8a8d46e7e00f8b"
        private const val limit = 30
    }

    @GET("data/top/mktcapfull?limit=$limit&tsym=USD")
    suspend fun getCoins(
        @Query("api_key") apiKey: String = API_KEY
    ): CoinListResponse
}