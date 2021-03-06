package com.mk.cryptolisting.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.cryptolisting.data.CoinRepositoryImpl
import com.mk.cryptolisting.domain.repository.CoinRepository
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
    }

    fun getCoins(fetchFromRemote: Boolean = false) {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            repository.getAllCoins(fetchFromRemote)
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