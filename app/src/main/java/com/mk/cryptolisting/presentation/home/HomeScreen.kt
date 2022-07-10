package com.mk.cryptolisting.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mk.cryptolisting.R
import com.mk.cryptolisting.components.ErrorScreen
import com.mk.cryptolisting.components.Loader
import com.mk.cryptolisting.domain.models.Coin
import com.mk.cryptolisting.presentation.home.components.CoinItem

@Composable
fun HomeScreen(
    onCoinClick: (Coin) -> Unit,
    viewmodel: HomeViewModel = hiltViewModel(),
) {

    val state = viewmodel.state

    if (state.isLoading) {
        Loader()
    } else if (state.coins.isNotEmpty()) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
                Text(text = stringResource(R.string.top_coins),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp)
            }
            items(state.coins) { coin ->
                CoinItem(coin = coin, onClick = onCoinClick)
            }
        }
    } else {
        ErrorScreen(onClick = { viewmodel.getCoins(true) })
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(onCoinClick = {})
}