package com.red_velvet.flix.di

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.data.repository.MovieRepositoryImp
import com.red_velvet.flix.domain.usecase.GetPopularMoviesUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesService: MoviesService, movieDao: MovieDao): MovieRepository {
        return MovieRepositoryImp(moviesService, movieDao)
    }


    @Provides
    @Singleton
    fun providePopularMoviesUsecase(movieRepository: MovieRepository): GetPopularMoviesUsecase {
        return GetPopularMoviesUsecase(movieRepository)
    }
}