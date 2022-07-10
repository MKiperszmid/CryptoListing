package com.mk.cryptolisting.features.home

import com.mk.cryptolisting.domain.models.Coin

data class HomeState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList()
)
