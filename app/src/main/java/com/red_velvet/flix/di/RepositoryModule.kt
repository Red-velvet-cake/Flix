package com.red_velvet.flix.di

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.data.repository.MovieRepositoryImpl
import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.data.repository.TVShowsRepositoryImpl
import com.red_velvet.flix.data.repository.UserRepository
import com.red_velvet.flix.data.repository.UserRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindMoviesRepository(moviesRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Singleton
    @Binds
    abstract fun bindTVShowsRepository(tvShowsRepositoryImpl: TVShowsRepositoryImpl): TVShowsRepository

    @Singleton
    @Binds
    abstract fun bindUserRepository(userRepositoryImp: UserRepositoryImp): UserRepository
}