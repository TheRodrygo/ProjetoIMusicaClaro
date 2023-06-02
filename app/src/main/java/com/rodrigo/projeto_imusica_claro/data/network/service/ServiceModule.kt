package com.rodrigo.projeto_imusica_claro.data.network.service

import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModules = module {

    single {
        val retrofit: Retrofit = get()
        retrofit.create(RedditService::class.java)
    }
}