package com.red_velvet.flix.di

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.data.repository.MovieRepositoryImp
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
        return MovieRepositoryImp(moviesService, movieDao, exceptionHandler)
    }
}