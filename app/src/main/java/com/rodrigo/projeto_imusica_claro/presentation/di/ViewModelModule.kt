package com.rodrigo.projeto_imusica_claro.presentation.di

import com.rodrigo.projeto_imusica_claro.presentation.home.screen.home.HomeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {

    viewModel {
        HomeListViewModel(
            getRedditInformationUseCase = get()
        )
    }
}