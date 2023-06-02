package com.rodrigo.projeto_imusica_claro.data.network.model

import com.google.gson.annotations.SerializedName

data class RedditDataResponse(
    @SerializedName("children") val children: List<RedditChildrenResponse>
)