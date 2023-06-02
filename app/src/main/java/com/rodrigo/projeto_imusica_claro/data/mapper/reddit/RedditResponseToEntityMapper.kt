package com.rodrigo.projeto_imusica_claro.data.mapper.reddit

import com.rodrigo.projeto_imusica_claro.common.mapper.Mapper
import com.rodrigo.projeto_imusica_claro.data.network.model.RedditDataResponse
import com.rodrigo.projeto_imusica_claro.data.network.model.RedditResponse
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.Reddit
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.RedditData

class RedditResponseToEntityMapper(
    private val redditDataToEntityMapper: Mapper<RedditDataResponse, RedditData>,
) : Mapper<RedditResponse, Reddit> {
    override fun map(input: RedditResponse): Reddit =
        with(input) {
            Reddit(
                redditData = redditDataToEntityMapper.map(data)
            )
    }
}