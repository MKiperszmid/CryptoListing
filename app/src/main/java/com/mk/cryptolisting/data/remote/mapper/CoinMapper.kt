package com.mk.cryptolisting.data.remote.mapper

import com.mk.cryptolisting.data.remote.dto.Data
import com.mk.cryptolisting.domain.models.Coin

fun Data.toDomain(): Coin? {
    return try {
        Coin(
            name = this.coinInfo.fullName,
            id = this.coinInfo.name,
            price = this.rAW.uSD.pRICE,
            icon = "https://www.cryptocompare.com/" + this.coinInfo.imageUrl
        )
    } catch (e: Exception) {
        null
    }
}