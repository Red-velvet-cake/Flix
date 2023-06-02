package com.red_velvet.flix.data.repository

import retrofit2.Response

abstract class BaseRepository {

    protected suspend fun <I, O> wrap(
        function: suspend () -> Response<I>,
        mapper: (I) -> O,
        extractResponse: (Response<I>) -> O
    ): O {
        val response = function()
        return if (response.isSuccessful) {
            extractResponse(response)?: throw Throwable()
        } else {
            throw Throwable("response is not successful")
        }
    }
}