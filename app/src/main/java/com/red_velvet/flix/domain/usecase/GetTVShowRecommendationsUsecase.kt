package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.series.SeriesEntity
import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetTVShowRecommendationsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, page: Int = 1): List<SeriesEntity> {
        return tvShowsRepository.getTVShowRecommendations(seriesId, page)
    }
}