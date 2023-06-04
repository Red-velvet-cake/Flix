package com.red_velvet.flix.di

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.local.database.dao.TvShowDao
import com.red_velvet.flix.data.local.sharedPrefs.SharedPrefs
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.data.repository.MovieRepositoryImpl
import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.data.repository.TVShowsRepositoryImpl
import com.red_velvet.flix.data.repository.UserRepository
import com.red_velvet.flix.data.repository.UserRepositoryImp
import com.red_velvet.flix.domain.utils.ExceptionHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        moviesService: MoviesService,
        movieDao: MovieDao,
        exceptionHandler: ExceptionHandler
    ): MovieRepository {
        return MovieRepositoryImpl(moviesService, movieDao, exceptionHandler)
    }

    @Provides
    @Singleton
    fun provideTVShowRepository(
        moviesService: MoviesService,
        tvShowDao: TvShowDao,
        exceptionHandler: ExceptionHandler
    ): TVShowsRepository {
        return TVShowsRepositoryImpl(moviesService, tvShowDao, exceptionHandler)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        moviesService: MoviesService,
        sharedPref: SharedPrefs,
        exceptionHandler: ExceptionHandler,
    ): UserRepository {
        return UserRepositoryImp(moviesService, sharedPref, exceptionHandler)
    }
}