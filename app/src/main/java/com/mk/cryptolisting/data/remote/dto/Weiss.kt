package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class Weiss(
    @field:Json(name = "MarketPerformanceRating")
    val marketPerformanceRating: String,
    @field:Json(name = "Rating")
    val rating: String,
    @field:Json(name = "TechnologyAdoptionRating")
    val technologyAdoptionRating: String
)