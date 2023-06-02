package com.rodrigo.projeto_imusica_claro.presentation.base.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.material.lightColors
import com.rodrigo.projeto_imusica_claro.R

@Composable
internal fun lightColors() = lightColors(
    background = colorResource(id = R.color.background),
    onBackground = colorResource(id = R.color.on_background),
    primary = colorResource(id = R.color.primary),
    primaryVariant = colorResource(id = R.color.primary_variant),
    onPrimary = colorResource(id = R.color.on_primary),
    secondary = colorResource(id = R.color.secondary),
    onSecondary = colorResource(id = R.color.on_secondary),
    error = colorResource(id = R.color.error),
    onError = colorResource(id = R.color.on_error),
    surface = colorResource(id = R.color.surface),
    onSurface = colorResource(id = R.color.on_surface),
)