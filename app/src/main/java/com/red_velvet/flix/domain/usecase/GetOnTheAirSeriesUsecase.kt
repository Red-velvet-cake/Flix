package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetOnTheAirSeriesUsecase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(): List<SeriesEntity> {
        return seriesRepository.getOnTheAirSeries()
    }
}