package com.red_velvet.flix.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.red_velvet.flix.data.local.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideAppSharedPreferences(
        sharedPreferences: SharedPreferences,
    ): SharedPref {
        return SharedPref(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(
        application: Application,
    ): SharedPreferences {
        return application.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    }
}