package com.mk.cryptolisting.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mk.cryptolisting.data.local.entity.CoinEntity

@Database(
    entities = [CoinEntity::class],
    version = 1
)
abstract class CoinDatabase : RoomDatabase() {
    abstract val dao: CoinDao
}