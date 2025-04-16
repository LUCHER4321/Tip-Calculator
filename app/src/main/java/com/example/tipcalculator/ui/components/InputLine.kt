package com.example.tipcalculator.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun InputLine(
    modifier: Modifier = Modifier,
    prevText: String = "",
    postText: String = "",
    value: Float,
    onValueChange: (Float) -> Unit,
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(text = prevText)
        TextField(
            value = value.toString(),
            onValueChange = { onValueChange(it.toFloat()) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f)
        )
        Text(text = postText)
    }
}