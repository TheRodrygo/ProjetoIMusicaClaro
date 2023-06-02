package com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeConfigurationViewModel : ViewModel() {
    val languages = listOf("PT", "EN")
    val selectedLanguage = mutableStateOf(languages[0])

    fun setLanguage(language: String) {
        selectedLanguage.value = language
    }

}