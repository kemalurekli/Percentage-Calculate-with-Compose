package com.kemalurekli.percentagecalculate.presentation.pages.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kemalurekli.percentagecalculate.presentation.pages.home.HomeScreenViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun UserInputArea(color: Color) {
    val viewModel = viewModel { HomeScreenViewModel() }
    val df = DecimalFormat("#.#######")
    df.roundingMode = RoundingMode.DOWN

    Column() {
        UserInputNumberArea(color) {
            viewModel.touchNumber = true
            viewModel.touchPercentage = false
        }
        UserInputPercentageArea(color) {
            viewModel.touchNumber = false
            viewModel.touchPercentage = true
        }
        ResultArea(color)
    }
}