package com.rodrigo.projeto_imusica_claro.data.network.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.reddit.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}