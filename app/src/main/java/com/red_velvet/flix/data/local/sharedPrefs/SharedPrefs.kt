package com.red_velvet.flix.data.local.sharedPrefs

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SharedPrefs @Inject constructor(private val sharedPreferences: SharedPreferences) {

    suspend fun setToken(key : String, value : String)
    {
        withContext(Dispatchers.IO){ sharedPreferences.edit().putString(key , value).apply()}
    }
    suspend fun getToken(key : String) : String?
    {
        return withContext(Dispatchers.IO){ sharedPreferences.getString(key , null)}
    }

}