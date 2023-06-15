package com.red_velvet.flix.domain.usecase.home.movies

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject


class GetTopRatedMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        return movieRepository.getLocalTopRatedMovies().onEmpty {
            saveTopRatedMoviesLocal()
        }
    }

    private suspend fun saveTopRatedMoviesLocal() {
        movieRepository.cacheTopRatedMovies(getTopRatedMovies())
    }

    private suspend fun getTopRatedMovies(): List<MovieEntity> {
        return movieRepository.getTopRatedMovies()
    }
}
