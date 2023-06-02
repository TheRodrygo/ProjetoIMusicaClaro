package com.rodrigo.projeto_imusica_claro.data.data_sources.reddit

import com.rodrigo.projeto_imusica_claro.data.network.model.RedditResponse
import com.rodrigo.projeto_imusica_claro.data.network.service.RedditService
import retrofit2.HttpException

class RedditRemoteDataSourceImpl(
    val service: RedditService
) : RedditRemoteDataSource {

    override suspend fun getRedditInformation(): RedditResponse {
        val response = service.getRedditInformation()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }
}