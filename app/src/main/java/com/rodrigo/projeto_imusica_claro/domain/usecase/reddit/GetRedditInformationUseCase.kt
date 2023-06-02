package com.rodrigo.projeto_imusica_claro.domain.usecase.reddit

import com.rodrigo.projeto_imusica_claro.domain.model.reddit.Reddit
import com.rodrigo.projeto_imusica_claro.domain.repository.RedditRepository
import kotlinx.coroutines.flow.Flow

class GetRedditInformationUseCase(
    private val repository: RedditRepository
) {
    operator fun invoke(): Flow<Reddit> {
        return repository.getRedditInformation()
    }
}