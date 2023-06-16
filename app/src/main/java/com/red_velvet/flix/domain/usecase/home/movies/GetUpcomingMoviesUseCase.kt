package com.red_velvet.flix.domain.usecase.home.movies

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.domain.usecase.caching.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetUpcomingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        if (shouldCacheApiResponseUseCase("upcoming_movies")) {
            refreshLocalUpcomingMovies()
        }
        return movieRepository.getLocalUpcomingMovies()
    }

    private suspend fun getUpcomingMovies(): List<MovieEntity> {
        return movieRepository.getUpcomingMovies()
    }

    private suspend fun refreshLocalUpcomingMovies() {
        val upcomingMovies = getUpcomingMovies()
        movieRepository.cacheUpcomingMovies(upcomingMovies)
    }

}