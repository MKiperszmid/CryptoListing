package com.mk.cryptolisting.features.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    println(viewModel)
    Text(text = "Detail Screen!")
}