package com.red_velvet.flix.domain.usecase.home.tvshows

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import com.red_velvet.flix.domain.usecase.caching.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetPopularSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        if (shouldCacheApiResponseUseCase("popular_series")) {
            refreshLocalPopularSeries()
        }
        return seriesRepository.getLocalPopularSeries()
    }

    private suspend fun getPopularSeries(): List<SeriesEntity> {
        return seriesRepository.getPopularSeries()
    }

    private suspend fun refreshLocalPopularSeries() {
        val popularSeries = getPopularSeries()
        seriesRepository.cachePopularSeries(popularSeries)
    }

}