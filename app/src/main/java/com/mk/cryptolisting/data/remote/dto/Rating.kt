package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class Rating(
    @field:Json(name = "Weiss")
    val weiss: Weiss
)