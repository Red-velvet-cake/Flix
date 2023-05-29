package com.red_velvet.flix.data.local

interface LocalData {
    fun setPrefs(key : String , value : String)
    fun getPrefs(key : String) : String
}