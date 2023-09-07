package com.kemalurekli.percentagecalculate.presentation.pages.home

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Calculate: CalculatorAction()
    object Decimal: CalculatorAction()
}