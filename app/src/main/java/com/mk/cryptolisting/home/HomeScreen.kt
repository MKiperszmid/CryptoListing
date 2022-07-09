package com.mk.cryptolisting.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewmodel: HomeViewModel = hiltViewModel()) {
    println(viewmodel)
}