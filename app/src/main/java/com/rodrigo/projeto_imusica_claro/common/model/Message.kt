package com.rodrigo.projeto_imusica_claro.common.model

import java.io.Serializable

data class Message(
    var message: String? = null,
    var error: MessageError? = null,
    var isSuccess: Boolean = false
) : Serializable {
    override fun equals(other: Any?): Boolean {
        return if (other is Message) {
            message == other.message && isSuccess == other.isSuccess && error == other.error
        } else super.equals(other)
    }
}