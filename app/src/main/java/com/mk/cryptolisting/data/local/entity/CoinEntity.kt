package com.mk.cryptolisting.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CoinEntity(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val abbreviation: String,
    val price: Double,
    val icon: String
)
