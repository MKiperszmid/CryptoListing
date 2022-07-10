package com.mk.cryptolisting.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mk.cryptolisting.domain.models.Coin
import java.text.DecimalFormat

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CoinItem(
    coin: Coin,
    onClick: (Coin) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(6.dp),
        onClick = {
            onClick(coin)
        }) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(6.dp)) {
            CoinVisuals(coin = coin)
            Text(text = "$${coin.price}",
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onBackground)
        }
    }
}

@Composable
fun CoinVisuals(coin: Coin) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(model = coin.icon,
            contentDescription = "coin icon",
            modifier = Modifier
                .size(75.dp)
                .padding(6.dp))
        Spacer(modifier = Modifier.padding(4.dp))
        Column {
            Text(text = coin.name,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = coin.id,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.alpha(0.7f))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CoinItemPreview() {
    val coin = Coin(
        "Bitcoin", "BTC", 1000.0, ""
    )
    CoinItem(coin = coin, onClick = {})

}