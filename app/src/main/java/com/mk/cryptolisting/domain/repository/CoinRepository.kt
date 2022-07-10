package com.mk.cryptolisting.domain.repository

import com.mk.cryptolisting.domain.models.Coin
import com.mk.cryptolisting.domain.models.CoinDetail

interface CoinRepository {
    suspend fun getAllCoins(fetchFromRemote: Boolean): Result<List<Coin>>

    suspend fun getCoinDetail(coinId: String): Result<List<CoinDetail>>
}