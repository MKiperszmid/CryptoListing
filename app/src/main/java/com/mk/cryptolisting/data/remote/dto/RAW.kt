package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class RAW(
    @field:Json(name = "USD")
    val uSD: USDX
)