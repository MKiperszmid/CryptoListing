package com.mk.cryptolisting.data.remote.dto


import com.squareup.moshi.Json

data class CoinListResponseItem(
    @field:Json(name = "asset_id")
    val assetId: String,
    @field:Json(name = "data_end")
    val dataEnd: String,
    @field:Json(name = "data_quote_end")
    val dataQuoteEnd: String,
    @field:Json(name = "data_quote_start")
    val dataQuoteStart: String,
    @field:Json(name = "data_start")
    val dataStart: String,
    @field:Json(name = "data_symbols_count")
    val dataSymbolsCount: Int,
    @field:Json(name = "data_trade_end")
    val dataTradeEnd: String,
    @field:Json(name = "data_trade_start")
    val dataTradeStart: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "price_usd")
    val priceUsd: Double,
    @field:Json(name = "type_is_crypto")
    val typeIsCrypto: Int,
    @field:Json(name = "volume_1day_usd")
    val volume1dayUsd: Double,
    @field:Json(name = "volume_1hrs_usd")
    val volume1hrsUsd: Double,
    @field:Json(name = "volume_1mth_usd")
    val volume1mthUsd: Double,
    @field:Json(name = "id_icon")
    val idIcon: String?
)