package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class DataX(
    @field:Json(name = "Aggregated")
    val aggregated: Boolean,
    @field:Json(name = "Data")
    val `data`: List<DataXX>,
    @field:Json(name = "TimeFrom")
    val timeFrom: Int,
    @field:Json(name = "TimeTo")
    val timeTo: Int
)