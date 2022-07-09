package com.mk.cryptolisting.data.remote.mapper

import com.mk.cryptolisting.data.remote.dto.CoinListResponseItem
import com.mk.cryptolisting.domain.models.Coin

fun CoinListResponseItem.toDomain(): Coin {
    val iconId = this.idIcon?.replace("-", "")
    val newIcon = iconId?.let { "https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/$it.png" } ?: "https://via.placeholder.com/100"
    return Coin(
        name = this.name,
        id = this.assetId,
        price = this.priceUsd,
        icon = newIcon
    )
}