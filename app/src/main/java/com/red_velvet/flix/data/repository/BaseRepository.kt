package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.remote.APIErrorHandler
import com.red_velvet.flix.domain.utils.FlixException
import okhttp3.internal.http2.ConnectionShutdownException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseRepository(private val apiErrorHandler: APIErrorHandler) {

    suspend fun <T> wrapApiCall(call: suspend () -> Response<T>): T {
        try {
            val response = call()
            if (response.isSuccessful) return response.body()!!
            throw apiErrorHandler.getFlixException(response.errorBody())
        } catch (e: SocketTimeoutException) {
            throw FlixException.TimeOut
        } catch (e: UnknownHostException) {
            throw FlixException.NoInternet
        } catch (e: ConnectionShutdownException) {
            throw FlixException.NoInternet
        } catch (e: IOException) {
            throw FlixException.NoInternet
        }
    }
}