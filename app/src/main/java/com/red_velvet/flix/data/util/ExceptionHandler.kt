package com.red_velvet.flix.data.util

import com.google.gson.Gson
import com.red_velvet.flix.data.remote.recoures.ApiResponse
import com.red_velvet.flix.domain.utils.NotFoundException
import com.red_velvet.flix.domain.utils.ServerException
import com.red_velvet.flix.domain.utils.TimeOutException
import com.red_velvet.flix.domain.utils.UnAuthorizedException
import okhttp3.ResponseBody
import javax.inject.Inject

class ExceptionHandler @Inject constructor() {
    private fun getErrorMessage(errorBody: ResponseBody?): String {
        return parseErrorBody(errorBody).statusMessage ?: DEFAULT_ERROR_MESSAGE
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
            UNAUTHORIZED_STATUS_CODE -> UnAuthorizedException(getErrorMessage(errorBody))
            NOT_FOUND_STATUS_CODE -> NotFoundException(getErrorMessage(errorBody))
            TIMEOUT_STATUS_CODE -> TimeOutException(getErrorMessage(errorBody))
            SERVER_ERROR_STATUS_CODE -> ServerException(getErrorMessage(errorBody))
            else -> Exception(getErrorMessage(errorBody))
        }
    }

    private companion object {
        const val DEFAULT_ERROR_MESSAGE = "Something went wrong"
        const val UNAUTHORIZED_STATUS_CODE = 401
        const val NOT_FOUND_STATUS_CODE = 404
        const val TIMEOUT_STATUS_CODE = 408
        const val SERVER_ERROR_STATUS_CODE = 500
    }
}

