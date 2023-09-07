package com.kemalurekli.percentagecalculate.presentation.pages.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kemalurekli.percentagecalculate.R
import com.kemalurekli.percentagecalculate.presentation.pages.home.HomeScreenViewModel

@Composable
fun ResultArea(
    backgroundcolor : Color
) {
    val viewModel = viewModel { HomeScreenViewModel() }
    val state = viewModel.state
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(width = 4.dp, shape = RoundedCornerShape(10.dp), color = MaterialTheme.colorScheme.secondary),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_check_24),
            contentDescription = "Your Value Icon Image",
            modifier = Modifier
                .padding(10.dp).size(26.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = state.lastResult.replace(".", ","),
            modifier = Modifier
                .fillMaxWidth().height(100.dp)
                .padding(start = 32.dp),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 40.sp
        )
    }
}