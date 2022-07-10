package com.mk.cryptolisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mk.cryptolisting.navigation.Route
import com.mk.cryptolisting.presentation.detail.DetailScreen
import com.mk.cryptolisting.presentation.home.HomeScreen
import com.mk.cryptolisting.ui.theme.CryptoListingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoListingTheme {
                val navigationController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    NavHost(navController = navigationController, startDestination = Route.HOME) {
                        composable(Route.HOME) {
                            HomeScreen(
                                onCoinClick = {
                                    navigationController.navigate(Route.DETAIL + "/${it.abbreviation}")
                                }
                            )
                        }
                        composable(Route.DETAIL + "/{coinId}",
                            arguments = listOf(navArgument("coinId") {
                                type = NavType.StringType
                            })) {
                            DetailScreen()
                        }
                    }
                }
            }
        }
    }
}
