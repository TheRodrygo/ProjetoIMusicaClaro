package com.rodrigo.projeto_imusica_claro.presentation.base.components.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun TopBar(
    title: String,
    onBackPressed: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    hasNavigationIcon: Boolean = true
) {
    TopAppBar(
        title = {Text(text = title,
                color = MaterialTheme.colors.surface)},
        backgroundColor = MaterialTheme.colors.secondary,
        navigationIcon = if (hasNavigationIcon) {
            {
                IconButton(onClick = onBackPressed) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        } else null,
        actions = actions
    )
}