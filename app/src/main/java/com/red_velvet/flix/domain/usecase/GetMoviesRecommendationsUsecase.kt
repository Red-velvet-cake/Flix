package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.model.movie.Movie
import javax.inject.Inject

class GetMoviesRecommendationsUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<Movie> {
        return movieRepository.getMovieRecommendations(movieId, page, language)
    }
}