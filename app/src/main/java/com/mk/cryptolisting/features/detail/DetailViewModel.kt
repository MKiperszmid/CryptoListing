package com.mk.cryptolisting.features.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mk.cryptolisting.data.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: CoinRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    init {
        val coinId = savedStateHandle.get<String>("coinId")
        println(coinId)
    }
}