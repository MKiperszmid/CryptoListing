package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class CoinDetailResponse(
    @field:Json(name = "Data")
    val `data`: DataX,
    @field:Json(name = "HasWarning")
    val hasWarning: Boolean,
    @field:Json(name = "Message")
    val message: String,
    @field:Json(name = "RateLimit")
    val rateLimit: RateLimitX,
    @field:Json(name = "Response")
    val response: String,
    @field:Json(name = "Type")
    val type: Int
)