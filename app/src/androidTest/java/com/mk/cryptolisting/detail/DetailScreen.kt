package com.mk.cryptolisting.detail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.lifecycle.SavedStateHandle
import com.mk.cryptolisting.data.FakeRepository
import com.mk.cryptolisting.presentation.detail.DetailScreen
import com.mk.cryptolisting.presentation.detail.DetailViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

class DetailScreen {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var repository: FakeRepository

    @Test
    fun loadEmptyDetail_showsErrorText() {
        repository = FakeRepository()
        repository.returnError = true
        val savedState = mockk<SavedStateHandle>(relaxed = true)
        every { savedState.get<String>("coinId") } returns "ETH"
        detailViewModel = DetailViewModel(repository, savedState)
        composeTestRule.setContent {
            DetailScreen(viewModel = detailViewModel)
        }
        composeTestRule.onNodeWithTag("coin_detail").assertDoesNotExist()
        composeTestRule.onNodeWithTag("error_screen").assertIsDisplayed()
    }

    @Test
    fun loadCoinDetail_showsDetails() {
        repository = FakeRepository()
        val savedState = mockk<SavedStateHandle>(relaxed = true)
        every { savedState.get<String>("coinId") } returns "ETH"
        detailViewModel = DetailViewModel(repository, savedState)
        composeTestRule.setContent {
            DetailScreen(viewModel = detailViewModel)
        }
        composeTestRule.onNodeWithTag("coin_detail").assertIsDisplayed()
        composeTestRule.onNodeWithTag("error_screen").assertDoesNotExist()
    }
}