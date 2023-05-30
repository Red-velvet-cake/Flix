package com.red_velvet.flix.data.remote

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    private val apiKey: String = ""
    private val requestToken: String = ""
    private val sessionId: String = ""

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
