package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class MetaData(
    @field:Json(name = "Count")
    val count: Int
)