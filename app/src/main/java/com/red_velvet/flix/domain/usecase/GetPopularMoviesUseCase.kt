package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): List<MovieEntity> {
        return movieRepository.getLocalPopularMovies()
    }
}