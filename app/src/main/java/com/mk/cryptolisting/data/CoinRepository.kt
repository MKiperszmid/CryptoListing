package com.mk.cryptolisting.data

import com.mk.cryptolisting.data.remote.CoinApi
import com.mk.cryptolisting.data.remote.mapper.toDomain
import com.mk.cryptolisting.domain.models.Coin
import com.mk.cryptolisting.domain.models.CoinDetail

class CoinRepository(
    private val api: CoinApi,
) {
    suspend fun getCoins(): Result<List<Coin>> {
        return try {
            val response = api.getCoins()
            Result.success(response.data.mapNotNull { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getCoinDetail(coinId: String): Result<List<CoinDetail>> {
        return try {
            val response = api.getCoinDetail(coinId).data.data
            Result.success(response.map { it.toDomain() } )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}