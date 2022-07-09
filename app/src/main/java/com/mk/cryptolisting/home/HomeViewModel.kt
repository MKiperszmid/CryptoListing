package com.mk.cryptolisting.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.cryptolisting.data.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CoinRepository
) : ViewModel() {
    init {
        viewModelScope.launch {
            val test = repository.getCoins()
            println(test)
        }
    }
}