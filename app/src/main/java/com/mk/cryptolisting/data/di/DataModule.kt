package com.mk.cryptolisting.data.di

import android.app.Application
import androidx.room.Room
import com.mk.cryptolisting.data.CoinRepository
import com.mk.cryptolisting.data.local.CoinDatabase
import com.mk.cryptolisting.data.remote.CoinApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): CoinApi {
        return Retrofit.Builder().baseUrl(CoinApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient).build().create()
    }

    @Singleton
    @Provides
    fun provideCoinDatabase(application: Application): CoinDatabase {
        return Room.databaseBuilder(application, CoinDatabase::class.java, "coin_db").build()
    }

    @Provides
    @Singleton
    fun provideRepository(api: CoinApi, database: CoinDatabase): CoinRepository {
        return CoinRepository(api = api, dao = database.dao)
    }

}