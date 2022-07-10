package com.mk.cryptolisting.data

import com.mk.cryptolisting.data.remote.CoinApi
import com.mk.cryptolisting.data.remote.mapper.toDomain
import com.mk.cryptolisting.domain.models.Coin

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
}