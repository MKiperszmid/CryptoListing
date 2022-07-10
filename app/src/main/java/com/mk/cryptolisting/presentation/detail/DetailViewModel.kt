package com.mk.cryptolisting.presentation.detail

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
        state = state.copy(
            coinId = savedStateHandle.get<String>("coinId") ?: "BTC"
        )
        getCoinDetail()
    }

    fun getCoinDetail() {
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            repository.getCoinDetail(state.coinId).onSuccess {
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