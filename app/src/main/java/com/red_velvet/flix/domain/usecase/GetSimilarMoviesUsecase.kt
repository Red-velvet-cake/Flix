package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.mapper.movie.toModel
import com.red_velvet.flix.domain.model.movie.Movie
import javax.inject.Inject

class GetSimilarMoviesUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        page: Int = 1,
        language: String? = null
    ): List<Movie> {
        return movieRepository.getSimilarMovies(movieId, page, language)
            .toModel()
    }
}