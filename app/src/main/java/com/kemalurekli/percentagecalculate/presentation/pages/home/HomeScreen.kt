package com.kemalurekli.percentagecalculate.presentation.pages.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.kemalurekli.percentagecalculate.presentation.pages.home.component.CustomInputArea
import com.kemalurekli.percentagecalculate.presentation.pages.home.component.UserInputArea
import com.kemalurekli.percentagecalculate.presentation.pages.home.util.AdmobBanner
import com.kemalurekli.percentagecalculate.presentation.pages.util.AppBar
import com.kemalurekli.percentagecalculate.presentation.theme.PercentageCalculateTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = { AppBar(navController) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.Center
            ) {
                UserInputArea(MaterialTheme.colorScheme.surface)
                CustomInputArea()
                AdmobBanner()
            }
        })
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    PercentageCalculateTheme {
        //HomeScreen()
    }
}