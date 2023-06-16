package com.red_velvet.flix.domain.usecase.home.movies

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.domain.usecase.cachingTimeStamps.ShouldCacheApiResponseUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow


class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        if (shouldCacheApiResponseUseCase("popular_movies")) {
            refreshLocalPopularMovies()
        }
        return movieRepository.getLocalPopularMovies()
    }

    private suspend fun getPopularMovies(): List<MovieEntity> {
        return movieRepository.getPopularMovies()
    }

    private suspend fun refreshLocalPopularMovies() {
        val popularMovies = getPopularMovies()
        movieRepository.cachePopularMovies(popularMovies)
    }

}