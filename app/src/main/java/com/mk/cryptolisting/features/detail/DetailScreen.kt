package com.mk.cryptolisting.features.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    else if (state.coinDetails.isNotEmpty()) {
        Text(text = "Amount of Info: ${state.coinDetails.size}")
    } else {
        Text(text = "Error getting info")
    }
    
}