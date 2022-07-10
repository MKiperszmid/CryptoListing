package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class CoinListResponse(
    @field:Json(name = "Data")
    val `data`: List<Data>,
    @field:Json(name = "HasWarning")
    val hasWarning: Boolean,
    @field:Json(name = "Message")
    val message: String,
    @field:Json(name = "MetaData")
    val metaData: MetaData,
    @field:Json(name = "RateLimit")
    val rateLimit: RateLimit,
    @field:Json(name = "SponsoredData")
    val sponsoredData: List<Any>,
    @field:Json(name = "Type")
    val type: Int
)