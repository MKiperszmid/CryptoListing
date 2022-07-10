package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class DISPLAY(
    @field:Json(name = "USD")
    val uSD: USD
)