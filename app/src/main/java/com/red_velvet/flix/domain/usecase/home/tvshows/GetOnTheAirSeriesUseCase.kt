package com.red_velvet.flix.domain.usecase.home.tvshows

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import com.red_velvet.flix.domain.usecase.caching.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetOnTheAirSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        if (shouldCacheApiResponseUseCase("on_the_air_series")) {
            refreshLocalOnTheAirSeries()
        }
        return seriesRepository.getLocalOnTheAirSeries()
    }

    private suspend fun getOnTheAirSeries(): List<SeriesEntity> {
        return seriesRepository.getOnTheAirSeries()
    }

    private suspend fun refreshLocalOnTheAirSeries() {
        val onTheAirSeries = getOnTheAirSeries()
        seriesRepository.cacheOnTheAirSeries(onTheAirSeries)
    }

}