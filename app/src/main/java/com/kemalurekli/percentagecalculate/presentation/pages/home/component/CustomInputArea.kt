package com.kemalurekli.percentagecalculate.presentation.pages.home.component

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kemalurekli.percentagecalculate.presentation.pages.home.CalculatorAction
import com.kemalurekli.percentagecalculate.presentation.pages.home.HomeScreenViewModel
import com.kemalurekli.percentagecalculate.presentation.pages.home.util.CustomButton
import com.kemalurekli.percentagecalculate.presentation.theme.DarkBlue90
import com.kemalurekli.percentagecalculate.presentation.theme.SelectedYellow


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CustomInputArea() {
    val viewModel = viewModel { HomeScreenViewModel() }
    val buttonSpacing = 8.dp
    val rowSpacing = 4.dp


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primary
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(rowSpacing),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CustomButton(
                    symbol = "7", color = DarkBlue90, modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(7))
                }
                CustomButton(
                    symbol = "8", color = DarkBlue90, modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(8))
                }
                CustomButton(
                    symbol = "9", color = DarkBlue90, modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(9))
                }
                CustomButton(
                    symbol = "DEL", color = SelectedYellow, modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Delete)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(rowSpacing),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CustomButton(
                    symbol = "4", color = DarkBlue90, modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(4))
                }
                CustomButton(
                    symbol = "5", color = DarkBlue90, modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(5))
                }
                CustomButton(
                    symbol = "6", color = DarkBlue90, modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(6))
                }
                CustomButton(
                    symbol = "AC", color = SelectedYellow, modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Clear)
                }
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth(0.75f)) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.padding(rowSpacing),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CustomButton(
                                symbol = "1",
                                color = DarkBlue90,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(1))
                            }
                            CustomButton(
                                symbol = "2",
                                color = DarkBlue90,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(2))
                            }
                            CustomButton(
                                symbol = "3",
                                color = DarkBlue90,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(3))
                            }
                        }
                        Row(
                            modifier = Modifier.padding(rowSpacing),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CustomButton(
                                symbol = "0",
                                color = DarkBlue90,
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(0))
                            }
                            CustomButton(
                                symbol = ",",
                                color = DarkBlue90,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorAction.Decimal)
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = rowSpacing, top = rowSpacing, end = rowSpacing)
                ) {
                    CustomButton(
                        symbol = "=", color = SelectedYellow, modifier = Modifier
                            .aspectRatio(0.472f)
                            .weight(1f)
                    ) {
                        viewModel.onAction(CalculatorAction.Calculate)
                    }
                }
            }
        }
}