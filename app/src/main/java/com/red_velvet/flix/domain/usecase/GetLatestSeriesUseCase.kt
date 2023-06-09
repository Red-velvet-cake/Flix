package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetLatestSeriesUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(): SeriesEntity {
        return seriesRepository.getLatestSeries()
    }
}