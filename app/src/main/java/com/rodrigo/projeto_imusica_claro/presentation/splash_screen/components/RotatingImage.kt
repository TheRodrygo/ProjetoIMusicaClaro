package com.rodrigo.projeto_imusica_claro.presentation.splash_screen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun RotatingImage(imageResId: Int, imageSize: Dp) {
    val animationTrigger = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        animationTrigger.value = true
    }

    val rotation by animateFloatAsState(
        targetValue = if (animationTrigger.value) 360f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )

    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .clip(CircleShape)
            .size(imageSize)
            .rotate(rotation)
    )
}