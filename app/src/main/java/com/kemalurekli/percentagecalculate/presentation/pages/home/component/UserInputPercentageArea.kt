package com.kemalurekli.percentagecalculate.presentation.pages.home.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun UserInputPercentageArea(
    backgroundcolor: Color,
    onClick: () -> Unit
) {
    val viewModel = viewModel { HomeScreenViewModel() }
    val state = viewModel.state
    var colorChoose by remember { mutableStateOf(Color.Black) }
    var bordersize by remember { mutableStateOf(2.dp) }


    if (viewModel.touchPercentage) {
        colorChoose = MaterialTheme.colorScheme.outline
        bordersize = 4.dp
    } else {
        colorChoose = MaterialTheme.colorScheme.onSurface
        bordersize = 2.dp
    }



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundcolor)
            .padding(4.dp)
            .border(width = bordersize, shape = RoundedCornerShape(10.dp), color = colorChoose)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.percentage_user_icon),
            contentDescription = "Percentage Icon Image",
            modifier = Modifier
                .padding(10.dp)
                .size(26.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = state.percentageRatio.replace(".", ","),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 40.sp,
            maxLines = 1
        )
    }
}