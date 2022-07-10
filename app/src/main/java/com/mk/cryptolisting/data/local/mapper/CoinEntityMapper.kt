package com.mk.cryptolisting.data.local.mapper

import com.mk.cryptolisting.data.local.entity.CoinEntity
import com.mk.cryptolisting.domain.models.Coin

fun CoinEntity.toDomain(): Coin {
    return Coin(
        name = this.name,
        abbreviation = this.abbreviation,
        price = this.price,
        icon = this.icon
    )
}

fun Coin.toEntity(): CoinEntity {
    return CoinEntity(
        name = this.name,
        abbreviation = this.abbreviation,
        price = this.price,
        icon = this.icon
    )
}