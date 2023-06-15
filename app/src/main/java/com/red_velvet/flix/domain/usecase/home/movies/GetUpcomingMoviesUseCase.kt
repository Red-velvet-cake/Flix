package com.red_velvet.flix.domain.usecase.home.movies

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        return movieRepository.getLocalUpcomingMovies().onEmpty {
            saveUpcomingMoviesLocal()
        }
    }

    private suspend fun saveUpcomingMoviesLocal() {
        movieRepository.cacheUpcomingMovies(getUpcomingMovies())
    }

    private suspend fun getUpcomingMovies(): List<MovieEntity> {
        return movieRepository.getUpcomingMovies()
    }
}