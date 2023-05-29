package com.red_velvet.flix.data.local

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPref @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {

    suspend fun saveToken(token: String, isGuest: Boolean) {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit {
                putString(if (isGuest) KEY_GUEST_TOKEN else KEY_USER_TOKEN, token)
            }
        }
    }

    suspend fun getToken(): String? {
        return withContext(Dispatchers.IO) {
            sharedPreferences.getString(KEY_USER_TOKEN, null)
                ?: sharedPreferences.getString(KEY_GUEST_TOKEN, null)
        }
    }

    companion object {
        const val KEY_GUEST_TOKEN = "Guest token"
        const val KEY_USER_TOKEN = "User token"
    }
}