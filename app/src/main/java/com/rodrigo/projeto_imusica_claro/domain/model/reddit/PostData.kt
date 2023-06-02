package com.rodrigo.projeto_imusica_claro.domain.model.reddit

import java.text.SimpleDateFormat
import java.util.*

class PostData(
    val title: String,
    val ups: Int,
    val created: Long,
    val author: String,
    val numComments: Int
){
    val createdDate: String
    get() {
        val date = Date(created * 1000L)
        val format = SimpleDateFormat("dd/MM/yyyy")
        format.timeZone = TimeZone.getTimeZone("UTC")
        return format.format(date)
    }
}