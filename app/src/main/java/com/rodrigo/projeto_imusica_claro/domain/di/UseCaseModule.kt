package com.rodrigo.projeto_imusica_claro.domain.di

import com.rodrigo.projeto_imusica_claro.domain.usecase.reddit.GetRedditInformationUseCase
import org.koin.dsl.module

val useCaseModules = module {
    single {
        GetRedditInformationUseCase(get())
    }
}