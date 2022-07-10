package com.mk.cryptolisting.features.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.cryptolisting.data.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: CoinRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var state by mutableStateOf(DetailState())
        private set

    init {
        val coinId = savedStateHandle.get<String>("coinId") ?: "BTC"
        getCoinDetail(coinId)
    }

    private fun getCoinDetail(coinId: String) {
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            repository.getCoinDetail(coinId).onSuccess {
                state = state.copy(
                    isLoading = false,
                    coinDetails = it
                )
            }.onFailure {
                state = state.copy(isLoading = false)
            }
        }
    }
}