package com.mk.cryptolisting.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mk.cryptolisting.R
import com.mk.cryptolisting.components.ErrorScreen
import com.mk.cryptolisting.components.Loader
import com.mk.cryptolisting.domain.models.CoinDetail
import me.bytebeats.views.charts.line.LineChart
import me.bytebeats.views.charts.line.LineChartData
import me.bytebeats.views.charts.line.render.line.SolidLineDrawer
import me.bytebeats.views.charts.line.render.point.FilledCircularPointDrawer
import me.bytebeats.views.charts.line.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.line.render.yaxis.SimpleYAxisDrawer
import me.bytebeats.views.charts.simpleChartAnimation
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state

    if (state.isLoading) {
        Loader()
    } else if (state.coinDetails.isNotEmpty()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)) {
            Text(text = stringResource(R.string.price_chart),
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Black,
                fontSize = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            LineChartView(state.coinDetails,
                modifier = Modifier
                    .background(MaterialTheme.colors.onBackground)
                    .padding(30.dp))
        }
    } else {
        ErrorScreen(onClick = { viewModel.getCoinDetail() })
    }
}

@Composable
private fun LineChartView(details: List<CoinDetail>, modifier: Modifier = Modifier) {
    LineChart(
        lineChartData = LineChartData(
            points = detailsToPoints(details)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .then(modifier),
        animation = simpleChartAnimation(),
        pointDrawer = FilledCircularPointDrawer(),
        lineDrawer = SolidLineDrawer(),
        xAxisDrawer = SimpleXAxisDrawer(),
        yAxisDrawer = SimpleYAxisDrawer(),
        horizontalOffset = 5f
    )
}

private fun detailsToPoints(details: List<CoinDetail>): List<LineChartData.Point> {
    return details.mapIndexedNotNull { index, coinDetail ->
        if (index % 2 == 0) {
            detailToPoint(coinDetail)
        } else null
    }
}

private fun detailToPoint(detail: CoinDetail): LineChartData.Point {
    val formatter = SimpleDateFormat("dd/MM", Locale.ENGLISH)
    val formattedDate = formatter.format(detail.date)
    return LineChartData.Point(
        detail.currentPrice.toFloat(), formattedDate
    )
}