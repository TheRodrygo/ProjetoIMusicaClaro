package com.rodrigo.projeto_imusica_claro.presentation.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rodrigo.projeto_imusica_claro.presentation.base.theme.ProjetoiMusicaClaroTheme
import com.rodrigo.projeto_imusica_claro.presentation.base.utils.BaseActivity
import com.rodrigo.projeto_imusica_claro.presentation.base.view_model.InactivityViewModel
import com.rodrigo.projeto_imusica_claro.presentation.home.navigation.HomeScreen
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : BaseActivity() {

    private val inactivityViewModel: InactivityViewModel by viewModel()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoiMusicaClaroTheme {
                val navController = rememberAnimatedNavController()
                AnimatedNavHost(
                    navController = navController,
                    startDestination = HomeScreen.HomeList.route,
                    builder = {
                        homeList(
                            navHostController = navController,
                            inactivityViewModel = inactivityViewModel
                        )
                        homeConfiguration(
                            navHostController = navController,
                            onBackPressedDispatcher = onBackPressedDispatcher,
                            activity = this@HomeActivity
                        )
                    }
                )
            }
        }
    }
}