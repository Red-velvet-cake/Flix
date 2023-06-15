package com.red_velvet.flix.domain.usecase.home.movies

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject


class GetNowPlayingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        return movieRepository.getLocalNowPlayingMovies().onEmpty {
            saveNowPlayingMoviesLocal()
        }
    }

    private suspend fun saveNowPlayingMoviesLocal() {
        movieRepository.cacheNowPlayingMovies(getNowPlayingMovies())
    }

    private suspend fun getNowPlayingMovies(): List<MovieEntity> {
        return movieRepository.getNowPlayingMovies()
    }
}
