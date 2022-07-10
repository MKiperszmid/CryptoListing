package com.mk.cryptolisting.data.local

import androidx.room.*
import com.mk.cryptolisting.data.local.entity.CoinEntity

@Dao
interface CoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(coin: CoinEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(coins: List<CoinEntity>)

    @Query("""
        DELETE FROM CoinEntity
    """)
    suspend fun removeAllCoins()

    @Query(
        """
            SELECT * FROM CoinEntity
        """
    )
    suspend fun getCoins(): List<CoinEntity>
}