package com.mk.cryptolisting.data.remote.mapper

import com.mk.cryptolisting.data.remote.dto.Data
import com.mk.cryptolisting.data.remote.dto.DataX
import com.mk.cryptolisting.data.remote.dto.DataXX
import com.mk.cryptolisting.domain.models.Coin
import com.mk.cryptolisting.domain.models.CoinDetail
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

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

fun DataXX.toDomain(): CoinDetail {
    return CoinDetail(
        currentPrice = this.close,
        date = Date(this.time * 1000)
    )
}
