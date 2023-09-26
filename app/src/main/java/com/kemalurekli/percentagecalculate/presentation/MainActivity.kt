package com.kemalurekli.percentagecalculate.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.MobileAds
import com.kemalurekli.percentagecalculate.presentation.pages.Screen
import com.kemalurekli.percentagecalculate.presentation.pages.home.HomeScreen
import com.kemalurekli.percentagecalculate.presentation.pages.settings.SettingsPage
import com.kemalurekli.percentagecalculate.presentation.pages.settings.TermsScreen
import com.kemalurekli.percentagecalculate.presentation.pages.util.DataStoreUtil
import com.kemalurekli.percentagecalculate.presentation.theme.PercentageCalculateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //This is for dark or light mode save.
    private lateinit var dataStoreUtil: DataStoreUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        val splashScreen = installSplashScreen()
        //Initialize the datastore.
        dataStoreUtil = DataStoreUtil(applicationContext)
        super.onCreate(savedInstanceState)

        //Get the default system mode.
        val systemTheme =
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES -> true
                Configuration.UI_MODE_NIGHT_NO -> false
                else -> false
            }


        setContent {
            //Get the user preference for mode.
            val theme = dataStoreUtil.getTheme(systemTheme).collectAsState(initial = systemTheme)

            //If it's true, activate the dark mode.
            PercentageCalculateTheme(darkTheme = theme.value) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen(navController)
                    }
                    composable(route = Screen.SettingScreen.route) {
                        //Sending data datastore and system default mode for switch position.
                        SettingsPage(navController, dataStoreUtil, theme.value)
                    }
                    composable(route = Screen.TermsScreen.route) {
                        TermsScreen(navController)
                    }
                }
            }
        }
        //Initialize the Ads.
        MobileAds.initialize(this) {}
    }
}
