package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetSimilarMoviesUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<MovieEntity> {
        return movieRepository.getSimilarMovies(movieId, page, language)
    }
}