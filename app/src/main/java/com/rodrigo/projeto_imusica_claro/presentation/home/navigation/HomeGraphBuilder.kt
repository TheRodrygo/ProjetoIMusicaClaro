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
import com.rodrigo.projeto_imusica_claro.presentation.base.view_model.InactivityViewModel
import com.rodrigo.projeto_imusica_claro.presentation.home.navigation.HomeScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.cam.HomeConfigurationCamScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.HomeConfigurationScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.HomeConfigurationViewModel
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.HomeListScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.HomeListViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeList(
    navHostController: NavHostController,
    inactivityViewModel: InactivityViewModel
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
            navHostController = navHostController,
            inactivityViewModel = inactivityViewModel
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeConfiguration(
    onBackPressedDispatcher: OnBackPressedDispatcher,
    activity: Activity,
    navHostController: NavHostController,
    inactivityViewModel: InactivityViewModel
) {
    composable(
        route = HomeScreen.HomeConfiguration.route,
        exitTransition = { exitTransition },
        popEnterTransition = { popEnterTransition }
    ) {
        val viewModel = getViewModel<HomeConfigurationViewModel>()
        HomeConfigurationScreen(
            viewModel = viewModel,
            backPressedDispatcher = onBackPressedDispatcher,
            activity = activity,
            navController = navHostController,
            inactivityViewModel = inactivityViewModel
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeConfigurationCam(
    onBackPressedDispatcher: OnBackPressedDispatcher,
    activity: Activity,
    inactivityViewModel: InactivityViewModel,
    navHostController: NavHostController,
) {
    composable(
        route = HomeScreen.HomeConfigurationCam.route,
        exitTransition = { exitTransition },
        popEnterTransition = { popEnterTransition }
    ) {
        HomeConfigurationCamScreen(
            backPressedDispatcher = onBackPressedDispatcher,
            activity = activity,
            inactivityViewModel = inactivityViewModel,
            navController = navHostController
        )
    }
}