package com.red_velvet.flix.domain.usecase.home.tvshows

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class GetAiringTodaySeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        return seriesRepository.getLocalAiringTodaySeries().onEmpty {
            saveAiringTodaySeriesLocal()
        }
    }

    private suspend fun saveAiringTodaySeriesLocal() {
        seriesRepository.cacheAiringTodaySeries(getAiringTodaySeries())
    }

    private suspend fun getAiringTodaySeries(): List<SeriesEntity> {
        return seriesRepository.getAiringTodaySeries()
    }
}