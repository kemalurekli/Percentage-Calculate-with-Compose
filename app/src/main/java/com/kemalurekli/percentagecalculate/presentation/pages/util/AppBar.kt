package com.kemalurekli.percentagecalculate.presentation.pages.util

import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kemalurekli.percentagecalculate.R
import com.kemalurekli.percentagecalculate.presentation.pages.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 20.sp,
            maxLines = 1,
            color = MaterialTheme.colorScheme.background,
            fontFamily = FontFamily.Default
        )
    },
        navigationIcon = {
            Icon(
                modifier = Modifier.width(45.dp),
                painter = painterResource(id = R.drawable.top_bar_logo),
                contentDescription = "Menu"
            )
            IconButton(onClick = {
                if (Screen.HomeScreen.route != navBackStackEntry?.destination?.route) {
                    navController.navigate(Screen.HomeScreen.route){
                        //This is for back button using. User can not return other page!
                        popUpTo(0)
                    }
                }
            }) {

            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        actions = {
            IconButton(onClick = {
                //If Screen is Settings, it'll be disable.
                if (Screen.SettingScreen.route != navBackStackEntry?.destination?.route) {
                    navController.navigate(Screen.SettingScreen.route)
                }

            }) {
                Icon(
                    modifier = Modifier.scale(1.6f),
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    )
}