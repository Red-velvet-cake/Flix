package com.red_velvet.flix.data.local.shared_prefs

interface SharedPrefs {
    suspend fun setToken(value: String)

    suspend fun getToken(): String?

    suspend fun setSessionId(value: String)

    suspend fun getSessionId(): String?

    suspend fun clearSessionId()
}