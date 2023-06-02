package com.rodrigo.projeto_imusica_claro.data.network.model

import com.google.gson.annotations.SerializedName

data class RedditResponse(
    @SerializedName("data") val data: RedditDataResponse
)