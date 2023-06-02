package com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration

import android.app.Activity
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.presentation.base.components.topbar.TopBar
import com.rodrigo.projeto_imusica_claro.presentation.base.theme.ProjetoiMusicaClaroTheme
import com.rodrigo.projeto_imusica_claro.presentation.home.navigation.HomeScreen.HomeConfiguration
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.components.LanguageDropdownMenu

@Composable
fun HomeConfigurationScreen(
    activity: Activity,
    navHostController: NavHostController,
    backPressedDispatcher: OnBackPressedDispatcher,
    viewModel: HomeConfigurationViewModel,
    homeConfiguration: HomeConfiguration?
) {
    ProjetoiMusicaClaroTheme {
        Scaffold(
            backgroundColor = MaterialTheme.colors.background,
            topBar = {
                TopBar(
                    title = stringResource(id = R.string.home_configuration_title),
                    hasConfigurationIcon = false,
                    onBackPressed = { backPressedDispatcher.onBackPressed() }
                )
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
                LanguageDropdownMenu(
                    activity = activity,
                    viewModel = viewModel
                )
            }
        }
    }
}