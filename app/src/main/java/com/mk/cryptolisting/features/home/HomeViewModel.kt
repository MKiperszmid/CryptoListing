package com.mk.cryptolisting.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.cryptolisting.data.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CoinRepository,
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        getCoins()
        viewModelScope.launch {
            val test = repository.getCoins()
            println(test)
        }
    }

    private fun getCoins() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            repository.getCoins()
                .onSuccess {
                    state = state.copy(
                        isLoading = false,
                        coins = it
                    )
                }
                .onFailure {
                    state = state.copy(
                        isLoading = false
                    )
                    displayError(it)
                }
        }
    }

    private fun displayError(throwable: Throwable) {
        println(throwable.localizedMessage)
    }
}