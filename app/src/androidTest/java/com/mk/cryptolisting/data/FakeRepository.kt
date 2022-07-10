package com.mk.cryptolisting.data

import com.mk.cryptolisting.domain.models.Coin
import com.mk.cryptolisting.domain.models.CoinDetail
import com.mk.cryptolisting.domain.repository.CoinRepository
import java.util.*

class FakeRepository : CoinRepository {
    var returnError = false
    companion object {
        val coins = listOf(
            Coin(
                "Bitcoin", "BTC", 1000.0, ""
            ),
            Coin(
                "Ethereum", "ETH", 500.0, ""
            )
        )

        val coinDetails = listOf(
            CoinDetail(
                1250.0, Date()
            ),
            CoinDetail(
                520.0, Date()
            )
        )
    }
    override suspend fun getAllCoins(fetchFromRemote: Boolean): Result<List<Coin>> {
        if (returnError) {
            return Result.failure(Throwable())
        }
        return Result.success(coins)
    }

    override suspend fun getCoinDetail(coinId: String): Result<List<CoinDetail>> {
        if (returnError) {
            return Result.failure(Throwable())
        }
        return Result.success(coinDetails)
    }
}