package com.rodrigo.projeto_imusica_claro.data.mapper.reddit

import com.rodrigo.projeto_imusica_claro.common.mapper.Mapper
import com.rodrigo.projeto_imusica_claro.data.network.model.PostDataResponse
import com.rodrigo.projeto_imusica_claro.data.network.model.RedditChildrenResponse
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.PostData
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.RedditChildren

class RedditChildrenListResponseToEntityMapper(
    private val postDataToEntityMapper: Mapper<PostDataResponse, PostData>,
) : Mapper<RedditChildrenResponse, RedditChildren> {
    override fun map(input: RedditChildrenResponse): RedditChildren =
        with(input) {
            RedditChildren(
                postData = postDataToEntityMapper.map(data)
            )
    }
}