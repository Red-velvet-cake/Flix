package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.util.ExceptionHandler
import retrofit2.Response

abstract class BaseRepository(private val exceptionHandler: ExceptionHandler) {

    suspend fun <T> wrapApiCall(call: suspend () -> Response<T>): T {
        val response = call()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }
}