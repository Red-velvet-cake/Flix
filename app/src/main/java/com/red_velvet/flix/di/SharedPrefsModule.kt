package com.red_velvet.flix.di

import android.content.Context
import android.content.SharedPreferences
import com.red_velvet.flix.data.local.shared_prefs.SharedPrefs
import com.red_velvet.flix.data.local.shared_prefs.SharedPrefsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefsModule {
    @Provides
    @Singleton
    fun getSharedPrefsUtil(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("FLIX_SHARED", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun getSharedPrefs(sharedPrefs: SharedPreferences): SharedPrefs {
        return SharedPrefsImpl(sharedPrefs)
    }
}