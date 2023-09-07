package com.kemalurekli.percentagecalculate.presentation.pages

sealed class Screen (val route : String){
    object HomeScreen : Screen("home_screen")
    object SettingScreen : Screen("setting_screen")
    object TermsScreen : Screen("terms_screen")

}
