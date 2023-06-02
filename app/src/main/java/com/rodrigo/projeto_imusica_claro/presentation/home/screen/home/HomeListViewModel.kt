package com.rodrigo.projeto_imusica_claro.presentation.home.screen.home

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.Reddit
import com.rodrigo.projeto_imusica_claro.domain.usecase.reddit.GetRedditInformationUseCase
import com.rodrigo.projeto_imusica_claro.presentation.base.model.StateUI
import com.rodrigo.projeto_imusica_claro.presentation.base.utils.NotificationDismissedReceiver
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeListViewModel(
    private val getRedditInformationUseCase: GetRedditInformationUseCase
) : ViewModel() {
    private val _getRedditInformation =
        MutableStateFlow<StateUI<Reddit>>(StateUI.Idle())
    val getRedditInformation: StateFlow<StateUI<Reddit>>
        get() = _getRedditInformation

    init {
        loadRedditInformationList()
    }

    private fun loadRedditInformationList() {
        viewModelScope.launch {
            getRedditInformationUseCase().onStart {
                _getRedditInformation.emit(StateUI.Processing())
            }.catch {
                _getRedditInformation.emit(StateUI.Error(it.message.toString()))
            }.collect { data ->
                _getRedditInformation.emit(StateUI.Processed(data))
            }
        }
    }

    fun refresh() {
        loadRedditInformationList()
    }
}