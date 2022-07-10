package com.mk.cryptolisting.data

import com.mk.cryptolisting.data.local.CoinDao
import com.mk.cryptolisting.data.local.entity.CoinEntity

class CoinDaoFake: CoinDao {
    private val coinList = mutableListOf<CoinEntity>()
    override suspend fun insertCoin(coin: CoinEntity) {
        coinList.add(coin)
    }

    override suspend fun insertCoins(coins: List<CoinEntity>) {
        coinList.addAll(coins)
    }

    override suspend fun removeAllCoins() {
        coinList.clear()
    }

    override suspend fun getCoins(): List<CoinEntity> {
        return coinList
    }
}