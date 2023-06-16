package com.red_velvet.flix.data.local.shared_prefs

interface SharedPrefs {
    suspend fun setToken(value: String)

    fun getToken(): String?

    suspend fun setSessionId(value: String)

    fun getSessionId(): String?

    suspend fun clearSessionId()

    fun setLong(key: String, time: Long)

    fun getLong(key: String, defaultValue: Long): Long
}