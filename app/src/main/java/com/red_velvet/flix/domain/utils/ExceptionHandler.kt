package com.red_velvet.flix.domain.utils

import com.google.gson.Gson
import com.red_velvet.flix.data.remote.recoures.ApiResponse
import okhttp3.ResponseBody
import javax.inject.Inject

class ExceptionHandler @Inject constructor() {
    private val msg: String = "No internet connection"

    private fun getErrorMessage(errorBody: ResponseBody?): String {
        return parseErrorBody(errorBody).statusMessage ?: msg
    }

    private fun parseErrorBody(errorBody: ResponseBody?): ApiResponse {
        return try {
            Gson().fromJson(errorBody!!.string(), ApiResponse::class.java)
        } catch (e: Exception) {
            throw e
        }
    }

    fun getException(
        statusCode: Int,
        errorBody: ResponseBody?
    ): Exception {
        return when (statusCode) {
            401 -> UnAuthorizedException(getErrorMessage(errorBody))
            404 -> NotFoundException(getErrorMessage(errorBody))
            408 -> TimeOutException(getErrorMessage(errorBody))
            500 -> ServerException(getErrorMessage(errorBody))
            else -> Exception(getErrorMessage(errorBody))
        }
    }
}

class UnAuthorizedException(msg: String) : Exception(msg)

class ServerException(msg: String) : Exception(msg)

class TimeOutException(msg: String) : Exception(msg)

class NotFoundException(msg: String) : Exception(msg)

