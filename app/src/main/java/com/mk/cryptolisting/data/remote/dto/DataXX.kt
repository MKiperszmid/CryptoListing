package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class DataXX(
    @field:Json(name = "close")
    val close: Double,
    @field:Json(name = "conversionSymbol")
    val conversionSymbol: String,
    @field:Json(name = "conversionType")
    val conversionType: String,
    @field:Json(name = "high")
    val high: Double,
    @field:Json(name = "low")
    val low: Double,
    @field:Json(name = "open")
    val `open`: Double,
    @field:Json(name = "time")
    val time: Long,
    @field:Json(name = "volumefrom")
    val volumefrom: Double,
    @field:Json(name = "volumeto")
    val volumeto: Double
)