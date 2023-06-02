package com.rodrigo.projeto_imusica_claro.common.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MessageError(
    @SerializedName("error_code")
    var code: Int? = null,
    @SerializedName("error_message")
    var message: String? = null
) : Serializable {
    constructor(message: String) : this(null, message)

    override fun equals(other: Any?): Boolean {
        return if (other is MessageError) {
            code == other.code && message == other.message
        } else super.equals(other)
    }
}