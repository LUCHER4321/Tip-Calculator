package com.example.tipcalculator.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {
    var dataVisualizerState by mutableStateOf(DataVisualizerState())
        private set

    fun tip(): Float{
        return dataVisualizerState.price * dataVisualizerState.tipPercentage / 100
    }

    fun total(): Float{
        return dataVisualizerState.price + tip()
    }

    fun setPrice(price: Float){
        dataVisualizerState = dataVisualizerState.copy(price = price)
    }

    fun setPercentage(percentage: Float){
        dataVisualizerState = dataVisualizerState.copy(tipPercentage = percentage)
    }
}