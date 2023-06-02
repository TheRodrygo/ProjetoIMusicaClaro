package com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.components

import android.util.Log
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.Reddit
import com.rodrigo.projeto_imusica_claro.presentation.base.components.custom_button.CustomButton
import com.rodrigo.projeto_imusica_claro.presentation.base.model.StateUI
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.HomeListViewModel
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.presentation.base.view_model.InactivityViewModel

@Composable
fun HomeListItem(
    modifier: Modifier = Modifier,
    homeList: StateUI<Reddit> = StateUI.Idle(),
    viewModel: HomeListViewModel,
    inactivityViewModel: InactivityViewModel
) {
    when {
        homeList.processed() -> {
            val processed = homeList as StateUI.Processed
            if (processed.data.redditData.redditChildren.isEmpty())
                ScreenMessage(
                    text = stringResource(id = R.string.home_list_empty_error),
                    buttonText = stringResource(id = R.string.home_list_try_again),
                    action = {
                        viewModel.refresh()
                    }
                )
            else
                Box(modifier = Modifier.pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        inactivityViewModel.onUserInteraction()
                    }
                }) {
                    Box(modifier = Modifier.pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            inactivityViewModel.onUserInteraction()
                        },
                        onPress = {
                            inactivityViewModel.onUserInteraction()
                        })
                        detectDragGestures { change, dragAmount ->
                            inactivityViewModel.onUserInteraction()
                        }
                    }) {
                        LazyColumn {
                            itemsIndexed(
                                processed.data.redditData.redditChildren,
                            ) { index, item ->
                                if (index == 0)
                                    Spacer(Modifier.padding(bottom = 0.dp))
                                HomeItem(
                                    postData = item.postData,
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }
        }
        homeList.loading() -> {
            Box(modifier = modifier.fillMaxSize()) {}
        }
        homeList.error() -> {
            ScreenMessage(
                text = stringResource(id = R.string.home_list_loading_error),
                buttonText = stringResource(id = R.string.home_list_try_again),
                action = {
                    viewModel.refresh()
                }
            )
        }
    }
}

@Composable
fun ScreenMessage(text: String, buttonText: String, action: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )
        CustomButton(text = buttonText, action = action, color = MaterialTheme.colors.secondary)
    }
}