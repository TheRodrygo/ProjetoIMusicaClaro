package com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.rodrigo.projeto_imusica_claro.R

@Composable
fun CircleImageWithBorder(
    imageUri: Uri?,
    contentDescription: String? = null,
    borderColor: Color = MaterialTheme.colors.secondary,
    borderWidth: Dp = 4.dp,
    onCameraClick: () -> Unit = {}
) {
    val painter = rememberImagePainter(data = imageUri)
    Box {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .border(borderWidth, borderColor, CircleShape)
                .size(100.dp) // Aumento do tamanho da imagem
        ) {
            if (imageUri != null) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(Color.Transparent)
                .clip(CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cam),
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .clickable(onClick = onCameraClick)
                    .background(MaterialTheme.colors.background)
                    .clip(shape = CircleShape)
            )
        }
    }
}

