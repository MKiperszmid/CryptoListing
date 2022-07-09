package com.mk.cryptolisting.data.remote

import com.mk.cryptolisting.data.remote.dto.CoinListResponse
import com.mk.cryptolisting.data.remote.dto.CoinListResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {
    companion object {
        const val BASE_URL = "https://rest.coinapi.io/"

        //Should be inside gradle.properties. But not doing it so you don't have to create a new one
        const val API_KEY = "50DAF180-34B2-4A97-8334-ED0F193AEFCC"
        private const val ASSETS = "BTC,ETH,BNB,XRP,ADA,SOL,DOGE,DOT,TRX,SHIB,AVAX,SAND"
    }

    @GET("v1/assets")
    suspend fun getCoins(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("filter_asset_id") assets: String = ASSETS,
    ): List<CoinListResponseItem>
}