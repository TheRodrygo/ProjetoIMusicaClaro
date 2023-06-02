package com.rodrigo.projeto_imusica_claro.presentation.home.screen.home

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.presentation.base.components.swipe_refresh.CustomSwipeRefresh
import com.rodrigo.projeto_imusica_claro.presentation.base.components.topbar.TopBar
import com.rodrigo.projeto_imusica_claro.presentation.base.theme.ProjetoiMusicaClaroTheme
import com.rodrigo.projeto_imusica_claro.presentation.base.view_model.InactivityViewModel
import com.rodrigo.projeto_imusica_claro.presentation.home.navigation.HomeScreen.HomeConfiguration
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.components.HomeListItem

@Composable
fun HomeListScreen(
    navHostController: NavHostController,
    viewModel: HomeListViewModel,
    inactivityViewModel: InactivityViewModel
) {
    val redditListUI = viewModel.getRedditInformation.collectAsState().value
    ProjetoiMusicaClaroTheme {
        val interactedModifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                inactivityViewModel.onUserInteraction()
            })
        }
        Scaffold(
            modifier = interactedModifier,
            backgroundColor = MaterialTheme.colors.background,
            topBar = {
                TopBar(
                    title = stringResource(id = R.string.home_screen_title),
                    hasNavigationIcon = false,
                    onConfigurationClicked = {
                        HomeConfiguration.navigate(
                            navHostController = navHostController,
                        )
                    }
                )
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
                CustomSwipeRefresh(
                    swipeRefreshState = rememberSwipeRefreshState(isRefreshing = redditListUI.loading()),
                    onRefresh = {
                        viewModel.refresh()
                    }) {
                    HomeListItem(
                        viewModel = viewModel,
                        homeList = redditListUI,
                        inactivityViewModel = inactivityViewModel
                    )
                }
            }
        }
    }
}