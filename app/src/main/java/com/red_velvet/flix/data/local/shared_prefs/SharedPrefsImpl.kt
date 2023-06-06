package com.red_velvet.flix.data.local.shared_prefs

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SharedPrefsImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SharedPrefs {

    override suspend fun setToken(value: String) {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit()
                .putString(TOKEN, value)
                .apply()
        }
    }

    override suspend fun getToken(): String? {
        return withContext(Dispatchers.IO) {
            sharedPreferences.getString(TOKEN, null)
        }
    }

    override suspend fun setSessionId(value: String) {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit()
                .putString(SESSION_ID, value)
                .apply()
        }
    }

    override suspend fun getSessionId(): String? {
        return withContext(Dispatchers.IO) {
            sharedPreferences.getString(SESSION_ID, null)
        }
    }

    override suspend fun clearSessionId() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }

    private companion object {
        const val TOKEN = "TOKEN"
        const val SESSION_ID = "SESSION_ID"
    }

}