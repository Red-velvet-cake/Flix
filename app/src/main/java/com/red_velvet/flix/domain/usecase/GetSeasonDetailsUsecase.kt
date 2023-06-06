package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.series.SeasonEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeasonDetailsUsecase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int): SeasonEntity {
        return seriesRepository.getSeasonDetails(seriesId, seasonNumber)
    }
}