package com.red_velvet.flix.di

import android.content.Context
import androidx.room.Room
import com.red_velvet.flix.data.local.database.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movie_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase) = movieDatabase.movieDao()

    @Singleton
    @Provides
    fun provideTvShowDao(movieDatabase: MovieDatabase) = movieDatabase.tvShowDao()

    @Singleton
    @Provides
    fun provideUserDataDao(movieDatabase: MovieDatabase) = movieDatabase.userDataDao()
}