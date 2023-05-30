package com.red_velvet.flix.data.remote

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    private val apiKey: String = "3302125369739e2ee7068474d8dcfa30"
    private val requestToken: String = "deb24ae7536a28bdc527bc73b55ea0ed7694321a"
    private val sessionId: String = "013b053dbf80bb460d03dacc524f59f877203bde"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .url(buildUrl(request))
            .build()

        return chain.proceed(newRequest)
    }

    private fun buildUrl(request: Request): HttpUrl {
        return request.url.newBuilder()
            .addQueryParameter(API_KEY, apiKey)
            .addQueryParameter(REQUEST_TOKEN, requestToken)
            .addQueryParameter(SESSION_ID, sessionId)
            .build()
    }

    companion object {
        const val API_KEY = "api_key"
        const val REQUEST_TOKEN = "request_token"
        const val SESSION_ID = "session_id"
    }
}
