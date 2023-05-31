package com.red_velvet.flix.data.local.sharedPrefs

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SharedPrefs @Inject constructor(private val sharedPreferences: SharedPreferences) {

    suspend fun setToken( value : String)
    {
        withContext(Dispatchers.IO){ sharedPreferences.edit().putString("TOKEN" , value).apply()}
    }
    suspend fun getToken() : String?
    {
        return withContext(Dispatchers.IO){ sharedPreferences.getString("TOKEN" , null)}
    }
    suspend fun setSessionId(value : String)
    {
        withContext(Dispatchers.IO){ sharedPreferences.edit().putString("SESSION_ID" , value).apply()}
    }
    suspend fun getSessionId() : String?
    {
        return withContext(Dispatchers.IO){ sharedPreferences.getString("SESSION_ID" , null)}
    }

}