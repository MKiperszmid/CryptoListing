package com.mk.cryptolisting.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.google.common.truth.Truth
import com.mk.cryptolisting.data.FakeRepository
import com.mk.cryptolisting.domain.models.Coin
import com.mk.cryptolisting.presentation.home.HomeScreen
import com.mk.cryptolisting.presentation.home.HomeViewModel
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var repository: FakeRepository

    @Test
    fun loadEmptyCoins_showsErrorText() {
        repository = FakeRepository()
        repository.returnError = true
        homeViewModel = HomeViewModel(repository)
        composeTestRule.setContent {
            HomeScreen(
                onCoinClick = {},
                viewmodel = homeViewModel
            )
        }
        composeTestRule.onNodeWithTag("coin_list").assertDoesNotExist()
        composeTestRule.onNodeWithTag("error_screen").assertIsDisplayed()
    }

    @Test
    fun loadCoins_showsAllCoins_clickReturnsCoin() {
        repository = FakeRepository()
        homeViewModel = HomeViewModel(repository)
        var clickedCoin by mutableStateOf<Coin?>(null)
        composeTestRule.setContent {
            HomeScreen(
                onCoinClick = { clickedCoin = it },
                viewmodel = homeViewModel
            )
        }
        Truth.assertThat(clickedCoin).isEqualTo(null)
        composeTestRule.onNodeWithTag("error_screen").assertDoesNotExist()
        composeTestRule.onNodeWithText("Bitcoin").performClick()
        Truth.assertThat(clickedCoin?.abbreviation).isEqualTo("BTC")
    }
}