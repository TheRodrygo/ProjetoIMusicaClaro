package com.rodrigo.projeto_imusica_claro.domain.repository

import com.rodrigo.projeto_imusica_claro.domain.model.reddit.Reddit
import kotlinx.coroutines.flow.Flow

interface RedditRepository {
    fun getRedditInformation(): Flow<Reddit>
}