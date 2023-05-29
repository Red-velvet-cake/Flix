package com.red_velvet.flix.data.local

import javax.inject.Inject

class LocalDataImpl@Inject constructor(sharedPrefs: SharedPrefs) : LocalData {
    override fun setPrefs(key: String, value: String) {
        TODO("Not yet implemented")
    }

    override fun getPrefs(key: String): String {
        TODO("Not yet implemented")
    }
}