package com.rodrigo.projeto_imusica_claro.data.network.model

import com.google.gson.annotations.SerializedName

data class PostDataResponse(
    @SerializedName("title") val title: String,
    @SerializedName("ups") val ups: Int,
    @SerializedName("created") val created: Double,
    @SerializedName("author") val author: String,
    @SerializedName("num_comments") val numComments: Int
)