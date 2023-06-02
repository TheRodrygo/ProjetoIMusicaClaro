package com.rodrigo.projeto_imusica_claro.data.di

import com.rodrigo.projeto_imusica_claro.common.mapper.NullableListMapperImpl
import com.rodrigo.projeto_imusica_claro.data.data_sources.reddit.RedditRemoteDataSourceImpl
import com.rodrigo.projeto_imusica_claro.data.mapper.reddit.PostDataResponseToEntityMapper
import com.rodrigo.projeto_imusica_claro.data.mapper.reddit.RedditChildrenListResponseToEntityMapper
import com.rodrigo.projeto_imusica_claro.data.mapper.reddit.RedditDataResponseToEntityMapper
import com.rodrigo.projeto_imusica_claro.data.mapper.reddit.RedditResponseToEntityMapper
import com.rodrigo.projeto_imusica_claro.data.repository.RedditRepositoryImpl
import com.rodrigo.projeto_imusica_claro.domain.repository.RedditRepository
import org.koin.dsl.module

val repositoryModules = module {
    single<RedditRepository> {
        RedditRepositoryImpl(
            redditRemoteDataSource = RedditRemoteDataSourceImpl(get()),
            redditResponseToEntityMapper = RedditResponseToEntityMapper(
                redditDataToEntityMapper = RedditDataResponseToEntityMapper(
                    redditChildrenListToEntityMapper = NullableListMapperImpl(
                        RedditChildrenListResponseToEntityMapper(
                            postDataToEntityMapper = PostDataResponseToEntityMapper()
                        )
                    )
                )
            )
        )
    }
}