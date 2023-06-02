package com.rodrigo.projeto_imusica_claro.presentation.home

import android.app.Activity
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.rodrigo.projeto_imusica_claro.presentation.base.theme.exitTransition
import com.rodrigo.projeto_imusica_claro.presentation.base.theme.popEnterTransition
import com.rodrigo.projeto_imusica_claro.presentation.home.navigation.HomeScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.HomeConfigurationScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.HomeConfigurationViewModel
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.HomeListScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.HomeListViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeList(
    navHostController: NavHostController
) {
    composable(
        route = HomeScreen.HomeList.route,
        arguments = listOf(navArgument(HomeScreen.HomeList.argumentKey) {
            type = NavType.BoolType
        }),
        exitTransition = {
            slideOutHorizontally(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        }
    ) {
        val viewModel = getViewModel<HomeListViewModel>()
        HomeListScreen(
            viewModel = viewModel,
            navHostController = navHostController
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeConfiguration(
    navHostController: NavHostController,
    onBackPressedDispatcher: OnBackPressedDispatcher,
    activity: Activity
) {
    composable(
        route = HomeScreen.HomeConfiguration.route,
        exitTransition = { exitTransition },
        popEnterTransition = { popEnterTransition }
    ) {
        val viewModel = getViewModel<HomeConfigurationViewModel>()
        val homeConfiguration: HomeScreen.HomeConfiguration? =
            navHostController.previousBackStackEntry?.savedStateHandle?.get<HomeScreen.HomeConfiguration>(
                HomeScreen.HomeConfiguration.argumentKey
            )
        HomeConfigurationScreen(
            viewModel = viewModel,
            navHostController = navHostController,
            backPressedDispatcher = onBackPressedDispatcher,
            homeConfiguration = homeConfiguration,
            activity = activity
        )
    }
}