package com.example.tipcalculator.ui.viewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tipcalculator.R
import com.example.tipcalculator.ui.components.InputLine

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel(),
){
    val inputModifier = Modifier.fillMaxWidth()//.align(Alignment.CenterVertically)
    Column(modifier = modifier) {
        InputLine(
            modifier = inputModifier,
            prevText = "${stringResource(id = R.string.price_text)}: $",
            value = viewModel.dataVisualizerState.price,
        ) {
            viewModel.setPrice(it)
        }
        InputLine(
            modifier = inputModifier,
            prevText = "${stringResource(id = R.string.tip_percentage)}: ",
            value = viewModel.dataVisualizerState.tipPercentage,
            postText = "%"
        ) {
            viewModel.setPercentage(it)
        }
        Text(text = "${stringResource(id = R.string.tip)}: $${viewModel.tip()}")
        Text(text = "${stringResource(id = R.string.total)}: $${viewModel.total()}")
    }
}