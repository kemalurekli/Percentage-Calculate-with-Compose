package com.kemalurekli.percentagecalculate.presentation.pages.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kemalurekli.percentagecalculate.R
import com.kemalurekli.percentagecalculate.presentation.pages.util.AppBar
import com.kemalurekli.percentagecalculate.presentation.pages.util.DataStoreUtil
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(
    navController: NavController,
    dataStoreUtil: DataStoreUtil,
    systemTheme: Boolean
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
                DarkModeOption(dataStoreUtil, systemTheme)
                TermsAndConditionsLink()
            }
        })
}

@Composable
fun DarkModeOption(dataStoreUtil: DataStoreUtil, systemTheme: Boolean) {

    var switchState by remember { mutableStateOf(systemTheme) }
    val coroutineScope = rememberCoroutineScope()
    val viewModel = viewModel { SettingsScreenViewModel() }



    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .defaultMinSize(minHeight = 60.dp)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.primary
            )
    ) {

        Text(
            text = stringResource(R.string.dark_mode),
            fontFamily = FontFamily.Default,
            modifier = Modifier.padding(start = 10.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(
                modifier = Modifier
                    .width(width = 1.dp)
                    .height(30.dp)
                    .background(color = MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Switch(
                checked = switchState,
                onCheckedChange = {
                    switchState = it
                    coroutineScope.launch {
                        dataStoreUtil.saveTheme(it)
                        viewModel.setTheme(it)
                    }

                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = MaterialTheme.colorScheme.primary,
                    uncheckedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                ), modifier = Modifier.padding(end = 10.dp)
            )
        }
    }
}

@Composable
fun TermsAndConditionsLink() {
    val uriHandler = LocalUriHandler.current
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 80.dp)
            .padding(10.dp)
            .border(

                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.primary
            )
            .clickable {
                uriHandler.openUri("https://gist.github.com/kemalurekli/f9bbc2bc4f7bda7aeb5db37ac9a13055")
            }
    ) {

        Text(
            text = stringResource(R.string.terms_and_conditions),
            fontFamily = FontFamily.Default,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}




