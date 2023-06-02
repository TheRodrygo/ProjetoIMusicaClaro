package com.rodrigo.projeto_imusica_claro.data.network.service

import com.rodrigo.projeto_imusica_claro.data.network.model.RedditResponse
import retrofit2.Response
import retrofit2.http.GET

interface RedditService {

    @GET("/r/artificial/hot")
    suspend fun getRedditInformation(): Response<RedditResponse>

}