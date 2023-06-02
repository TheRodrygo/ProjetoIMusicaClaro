package com.rodrigo.projeto_imusica_claro.data.mapper.reddit

import com.rodrigo.projeto_imusica_claro.common.mapper.Mapper
import com.rodrigo.projeto_imusica_claro.common.mapper.NullableListMapper
import com.rodrigo.projeto_imusica_claro.data.network.model.RedditChildrenResponse
import com.rodrigo.projeto_imusica_claro.data.network.model.RedditDataResponse
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.RedditChildren
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.RedditData

class RedditDataResponseToEntityMapper(
    private val redditChildrenListToEntityMapper: NullableListMapper<RedditChildrenResponse, RedditChildren>,
) : Mapper<RedditDataResponse, RedditData> {
    override fun map(input: RedditDataResponse): RedditData =
        with(input) {
            RedditData(
                redditChildren = redditChildrenListToEntityMapper.map(children)
            )
    }
}