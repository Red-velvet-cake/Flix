package com.red_velvet.flix.di

import android.content.Context
import android.content.SharedPreferences
import com.red_velvet.flix.data.local.SharedPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefsModule {
    @Provides
    fun getSharedPrefsUtil(@ApplicationContext context : Context , sharedPrefsName : String) : SharedPreferences
    {
        return context.getSharedPreferences(sharedPrefsName , Context.MODE_PRIVATE)
    }
    @Provides
    fun getSharedPrefs(sharedPrefs : SharedPreferences) : SharedPrefs{
        return SharedPrefs(sharedPrefs)
    }
}