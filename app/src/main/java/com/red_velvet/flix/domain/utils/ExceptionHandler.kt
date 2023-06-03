package com.red_velvet.flix.domain.utils

import com.google.gson.Gson
import com.red_velvet.flix.data.remote.dtos.ApiResponse
import okhttp3.ResponseBody

class ExceptionHandler(
    private val statusCode: Int,
    private val errorBody: ResponseBody?
) {
    private val msg: String = "No internet connection"

    private fun getErrorMessage(): String {
        return parseErrorBody().statusMessage ?: msg
    }

    private fun parseErrorBody(): ApiResponse {
        return try {
            Gson().fromJson(errorBody!!.string(), ApiResponse::class.java)
        } catch (e: Exception) {
            throw e
        }
    }

    fun handleException(): Exception {
        return when (statusCode) {
            401 -> UnAuthorizedException(getErrorMessage())
            404 -> NotFoundException(getErrorMessage())
            408 -> TimeOutException(getErrorMessage())
            500 -> ServerException(getErrorMessage())
            else -> Exception(getErrorMessage())
        }
    }
}

class UnAuthorizedException(msg: String) : Exception(msg)

class ServerException(msg: String) : Exception(msg)

class TimeOutException(msg: String) : Exception(msg)

class NotFoundException(msg: String) : Exception(msg)

