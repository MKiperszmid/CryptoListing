package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class Data(
    @field:Json(name = "CoinInfo")
    val coinInfo: CoinInfo,
    @field:Json(name = "DISPLAY")
    val dISPLAY: DISPLAY,
    @field:Json(name = "RAW")
    val rAW: RAW
)