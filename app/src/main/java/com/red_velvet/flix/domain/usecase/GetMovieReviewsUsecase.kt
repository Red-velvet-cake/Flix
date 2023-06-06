package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.Review
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieReviewsUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<Review> {
        return movieRepository.getMovieReviews(movieId, page, language)
    }
}