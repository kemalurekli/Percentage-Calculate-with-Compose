package com.kemalurekli.percentagecalculate.presentation.pages.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kemalurekli.percentagecalculate.R
import com.kemalurekli.percentagecalculate.presentation.pages.home.component.CustomInputArea
import com.kemalurekli.percentagecalculate.presentation.pages.home.component.UserInputArea
import com.kemalurekli.percentagecalculate.presentation.pages.home.util.AdmobBanner
import com.kemalurekli.percentagecalculate.presentation.pages.util.AppBar
import com.kemalurekli.percentagecalculate.presentation.theme.PercentageCalculateTheme
import com.kemalurekli.percentagecalculate.util.constant.MAX_NUM_LENGTH
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    val viewModel = viewModel { HomeScreenViewModel() }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val snackBarMessage = stringResource(R.string.maximum_9_numbers)


    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = { AppBar(navController) },
        content = { padding ->
            if ((viewModel.state.number.length > MAX_NUM_LENGTH) || (viewModel.state.percentageRatio.length > MAX_NUM_LENGTH)) {
                scope.launch {
                    snackbarHostState.showSnackbar(snackBarMessage)
                }
            }
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