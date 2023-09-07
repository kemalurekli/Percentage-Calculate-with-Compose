package com.kemalurekli.percentagecalculate.presentation.pages.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kemalurekli.percentagecalculate.constant.MAX_NUM_LENGTH
import java.math.RoundingMode
import java.text.DecimalFormat

class HomeScreenViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
    var touchNumber by mutableStateOf(true)
    var touchPercentage by mutableStateOf(false)


    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun calculate() {
        val number = state.number.toDoubleOrNull()
        val percentage = state.percentageRatio.toDoubleOrNull()
        if (number != null && percentage != null) {
            val df = DecimalFormat("#.######")
            df.roundingMode = RoundingMode.FLOOR
            state.lastResult = df.format(((number / 100) * percentage)).toString()
        } else {
            state.lastResult = ""
        }
    }


    private fun enterNumber(numberInput: Int) {
        if (touchNumber) {
            if (state.number.length <= MAX_NUM_LENGTH) {
                state = state.copy(
                    number = state.number + numberInput
                )
                calculate()
            }
        } else {
            if (state.percentageRatio.length <= MAX_NUM_LENGTH) {
                state = state.copy(
                    percentageRatio = state.percentageRatio + numberInput
                )
                calculate()
            }
        }
    }

    private fun delete() {
        if (touchNumber) {
            when {
                state.number.isNotBlank() -> {
                    state = state.copy(number = state.number.dropLast(1))
                }
            }
            calculate()

        } else {
            when {
                state.percentageRatio.isNotBlank() -> {
                    state = state.copy(
                        percentageRatio = state.percentageRatio.dropLast(1)
                    )
                }
            }
            calculate()
        }
    }

    private fun enterDecimal() {
        if (touchNumber) {
            if (!state.number.contains(".") && state.number.isNotBlank()) {
                state = state.copy(
                    number = state.number + "."
                )
                return
            }
        } else {
            if (!state.percentageRatio.contains(".") && state.percentageRatio.isNotBlank()) {
                state = state.copy(
                    percentageRatio = state.percentageRatio + "."
                )
                return
            }
        }
    }
}