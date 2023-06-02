package com.rodrigo.projeto_imusica_claro.data.data_sources.reddit

import com.rodrigo.projeto_imusica_claro.data.network.model.RedditResponse

interface RedditRemoteDataSource {
    suspend fun getRedditInformation(): RedditResponse
}