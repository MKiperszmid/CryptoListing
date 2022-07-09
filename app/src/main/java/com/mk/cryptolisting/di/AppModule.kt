package com.mk.cryptolisting.di

import com.mk.cryptolisting.data.CoinRepository
import com.mk.cryptolisting.data.remote.CoinApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(api: CoinApi): CoinRepository {
        return CoinRepository(api)
    }
}