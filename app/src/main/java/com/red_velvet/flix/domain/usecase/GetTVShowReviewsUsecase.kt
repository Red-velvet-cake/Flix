package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.ReviewEntity
import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetTVShowReviewsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, page: Int = 1): List<ReviewEntity> {
        return tvShowsRepository.getTVShowReviews(seriesId, page)
    }
}