package com.red_velvet.flix.domain.usecase.home.tvshows

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject


class GetOnTheAirSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        return seriesRepository.getLocalOnTheAirSeries().onEmpty {
            saveOnTheAirSeriesLocal()
        }
    }

    private suspend fun saveOnTheAirSeriesLocal() {
        seriesRepository.cacheOnTheAirSeries(getOnTheAirSeries())
    }

    private suspend fun getOnTheAirSeries(): List<SeriesEntity> {
        return seriesRepository.getOnTheAirSeries()
    }
}