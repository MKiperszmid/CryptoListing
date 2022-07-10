package com.mk.cryptolisting.features.detail

import com.mk.cryptolisting.domain.models.CoinDetail

data class DetailState(
    val isLoading: Boolean = false,
    val coinDetails: List<CoinDetail> = emptyList()
)
