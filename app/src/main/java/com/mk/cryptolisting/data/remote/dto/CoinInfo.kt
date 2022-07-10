package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class CoinInfo(
    @field:Json(name = "Algorithm")
    val algorithm: String,
    @field:Json(name = "AssetLaunchDate")
    val assetLaunchDate: String,
    @field:Json(name = "BlockNumber")
    val blockNumber: Int,
    @field:Json(name = "BlockReward")
    val blockReward: Double,
    @field:Json(name = "BlockTime")
    val blockTime: Double,
    @field:Json(name = "DocumentType")
    val documentType: String,
    @field:Json(name = "FullName")
    val fullName: String,
    @field:Json(name = "Id")
    val id: String,
    @field:Json(name = "ImageUrl")
    val imageUrl: String,
    @field:Json(name = "Internal")
    val `internal`: String,
    @field:Json(name = "MaxSupply")
    val maxSupply: Double,
    @field:Json(name = "Name")
    val name: String,
    @field:Json(name = "NetHashesPerSecond")
    val netHashesPerSecond: Double,
    @field:Json(name = "ProofType")
    val proofType: String,
    @field:Json(name = "Rating")
    val rating: Rating,
    @field:Json(name = "Type")
    val type: Int,
    @field:Json(name = "Url")
    val url: String
)