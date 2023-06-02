package com.rodrigo.projeto_imusica_claro.presentation.base.components.custom_button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    text: String,
    action: () -> Unit,
    color: Color
) {
    Button(
        onClick = action,
        contentPadding = PaddingValues(
            vertical = 16.dp, horizontal = 8.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        ),
        shape = RoundedCornerShape(25)
    ) {
        Text(text = text)
    }
}