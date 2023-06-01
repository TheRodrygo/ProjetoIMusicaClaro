package com.rodrigo.projeto_imusica_claro.presentation.home.screen.home

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.rodrigo.projeto_imusica_claro.presentation.base.theme.ProjetoiMusicaClaroTheme

@Composable
fun HomeListScreen(
    navHostController: NavHostController,
    backPressedDispatcher: OnBackPressedDispatcher,
    viewModel: HomeListViewModel,
) {
    ProjetoiMusicaClaroTheme {
        Scaffold(
            backgroundColor = MaterialTheme.colors.background,
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues = paddingValues)) {

            }
        }
    }
}