package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeriesRecommendationsUsecase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int, page: Int = 1): List<SeriesEntity> {
        return seriesRepository.getSeriesRecommendations(seriesId, page)
    }
}