package com.red_velvet.flix.domain.usecase.home.tvshows

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class GetTopRatedSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        return seriesRepository.getLocalTopRatedSeries().onEmpty {
            saveTopRatedSeriesLocal()
        }
    }

    private suspend fun saveTopRatedSeriesLocal() {
        seriesRepository.cacheTopRatedSeries(getTopRatedSeries())
    }

    private suspend fun getTopRatedSeries(): List<SeriesEntity> {
        return seriesRepository.getTopRatedSeries()
    }
}