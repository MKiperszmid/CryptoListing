package com.mk.cryptolisting.domain.models

data class Coin(
    val name: String,
    val abbreviation: String,
    val price: Double,
    val icon: String,
)
