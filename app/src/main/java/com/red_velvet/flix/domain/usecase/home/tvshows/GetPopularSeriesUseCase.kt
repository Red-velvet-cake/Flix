package com.red_velvet.flix.domain.usecase.home.tvshows

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class GetPopularSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        return seriesRepository.getLocalPopularSeries().onEmpty {
            savePopularSeriesLocal()
        }
    }

    private suspend fun savePopularSeriesLocal() {
        seriesRepository.cachePopularSeries(getPopularSeries())
    }

    private suspend fun getPopularSeries(): List<SeriesEntity> {
        return seriesRepository.getPopularSeries()
    }
}