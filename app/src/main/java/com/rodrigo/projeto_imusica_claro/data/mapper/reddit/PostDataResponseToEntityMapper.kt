package com.rodrigo.projeto_imusica_claro.data.mapper.reddit

import com.rodrigo.projeto_imusica_claro.common.mapper.Mapper
import com.rodrigo.projeto_imusica_claro.data.network.model.PostDataResponse
import com.rodrigo.projeto_imusica_claro.data.network.model.RedditDataResponse
import com.rodrigo.projeto_imusica_claro.data.network.model.RedditResponse
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.PostData
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.Reddit
import com.rodrigo.projeto_imusica_claro.domain.model.reddit.RedditData

class PostDataResponseToEntityMapper() : Mapper<PostDataResponse, PostData> {
    override fun map(input: PostDataResponse): PostData =
        with(input) {
            PostData(
                title = title,
                ups = ups,
                created = created.toLong(),
                author = author,
                numComments = numComments
            )
    }
}