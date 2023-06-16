package com.red_velvet.flix.domain.usecase.home.movies

import android.util.Log
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEmpty

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        return movieRepository.getLocalPopularMovies().onEmpty {
            savePopularMoviesLocal()
        }
    }

    private suspend fun savePopularMoviesLocal() {
        movieRepository.cachePopularMovies(getPopularMovies())
    }

    private suspend fun getPopularMovies(): List<MovieEntity> {
        return movieRepository.getPopularMovies()
    }
}