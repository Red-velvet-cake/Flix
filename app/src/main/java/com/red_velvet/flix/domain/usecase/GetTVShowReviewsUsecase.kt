package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.model.Review
import javax.inject.Inject

class GetTVShowReviewsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, page: Int = 1): List<Review> {
        return tvShowsRepository.getTVShowReviews(seriesId, page)
    }
}