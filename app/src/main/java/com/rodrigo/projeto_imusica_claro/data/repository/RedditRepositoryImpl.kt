package com.rodrigo.projeto_imusica_claro.data.repository

import com.rodrigo.projeto_imusica_claro.common.mapper.Mapper
import com.rodrigo.projeto_imusica_claro.data.data_sources.reddit.RedditRemoteDataSource
import com.rodrigo.projeto_imusica_claro.data.network.model.RedditResponse
import com.rodrigo.projeto_imusica_claro.data.network.util.unsafeApiCall
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.Reddit
import com.rodrigo.projeto_imusica_claro.domain.repository.RedditRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RedditRepositoryImpl(
    private val redditRemoteDataSource: RedditRemoteDataSource,
    private val redditResponseToEntityMapper: Mapper<RedditResponse, Reddit>
) : RedditRepository {
    override fun getRedditInformation(): Flow<Reddit> {
        return flow {
            unsafeApiCall {
                val response = redditRemoteDataSource.getRedditInformation()
                val mappedResponse = redditResponseToEntityMapper.map(response)
                emit(mappedResponse)
            }
        }.flowOn(Dispatchers.IO)
    }
}