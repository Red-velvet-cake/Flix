package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.model.Review
import javax.inject.Inject

class GetMovieReviewsUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        page: Int = 1,
        language: String? = null
    ): List<Review> {
        TODO("Create mapper for Review")
//        return movieRepository.getMovieReviews(movieId, page, language).toModel()
    }
}