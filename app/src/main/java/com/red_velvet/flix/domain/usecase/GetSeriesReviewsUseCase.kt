package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeriesReviewsUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int, page: Int = 1): List<ReviewEntity> {
        return seriesRepository.getSeriesReviews(seriesId, page)
    }
}