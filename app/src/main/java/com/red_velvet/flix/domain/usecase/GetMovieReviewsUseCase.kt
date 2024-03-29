package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieReviewsUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        page: Int? = null,
    ): List<ReviewEntity> {
        return movieRepository.getMovieReviews(movieId, page)
    }
}