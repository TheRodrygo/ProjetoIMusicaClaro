package com.rodrigo.projeto_imusica_claro.data.network.util

import com.google.gson.Gson
import com.rodrigo.projeto_imusica_claro.common.model.Message
import kotlinx.coroutines.coroutineScope
import retrofit2.HttpException
import java.io.IOException
import com.rodrigo.projeto_imusica_claro.common.model.Result
import org.json.JSONObject

internal suspend fun <T : Any> unsafeApiCall(call: suspend () -> T): T {
    return coroutineScope {
        try {
            call()
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> {
                    Result.Error(Result.Error.Type.NETWORK)
                    throw Throwable("Ocorreu um problema de conexão")
                }
                is HttpException -> {
                    val code = throwable.code()
                    val message = convertErrorBody(throwable)
                    Result.Error(Result.Error.Type.HTTP, code, message)
                    throw Throwable(message?.error?.message)
                }
                else -> {
                    Result.Error(Result.Error.Type.GENERIC)
                    throw throwable
                }
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): Message? {
    return try {
        val json: String = throwable.response()?.errorBody()?.string() ?: ""
        val jsonObject = JSONObject(json)
        Gson().fromJson(jsonObject.toString(), Message::class.java)
    } catch (throwable: Throwable) {
        return null
    }
}