package com.rodrigo.projeto_imusica_claro.presentation.base.components.swipe_refresh

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState

@Composable
fun CustomSwipeRefresh(
    swipeRefreshState: SwipeRefreshState,
    onRefresh: () -> Unit,
    indicatorBackgroundColor: Color = MaterialTheme.colors.surface,
    indicatorContentColor: Color = MaterialTheme.colors.secondary,
    indicatorScale: Boolean = true,
    content: @Composable () -> Unit

) {
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = onRefresh,
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = trigger,
                scale = indicatorScale,
                backgroundColor = indicatorBackgroundColor,
                contentColor = indicatorContentColor
            )
        }
    ) {
        content()
    }
}