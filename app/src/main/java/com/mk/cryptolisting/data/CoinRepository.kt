package com.mk.cryptolisting.data

import com.mk.cryptolisting.data.local.CoinDao
import com.mk.cryptolisting.data.local.mapper.toDomain
import com.mk.cryptolisting.data.local.mapper.toEntity
import com.mk.cryptolisting.data.remote.CoinApi
import com.mk.cryptolisting.data.remote.mapper.toDomain
import com.mk.cryptolisting.domain.models.Coin
import com.mk.cryptolisting.domain.models.CoinDetail

class CoinRepository(
    private val api: CoinApi,
    private val dao: CoinDao,
) {
    suspend fun getCoins(): Result<List<Coin>> {
        return getFromApi()
    }

    suspend fun getAllCoins(
        fetchFromRemote: Boolean = false,
    ): Result<List<Coin>> {
        val localCoins = getLocally()
        val loadFromCache = localCoins.isNotEmpty() && !fetchFromRemote
        if (loadFromCache) {
            return Result.success(localCoins)
        }
        return getFromApi().onSuccess {
            dao.removeAllCoins()
            saveLocally(it)
            return Result.success(it)
        }.onFailure {
            if (localCoins.isNotEmpty()) {
                return Result.success(localCoins)
            }
            return Result.failure(it)
        }
    }

    private suspend fun getLocally(): List<Coin> {
        return dao.getCoins().map { it.toDomain() }
    }

    private suspend fun saveLocally(coinList: List<Coin>) {
        val coins = coinList.map { it.toEntity() }
        dao.insertCoins(coins)
    }

    private suspend fun getFromApi(): Result<List<Coin>> {
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
            Result.success(response.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}