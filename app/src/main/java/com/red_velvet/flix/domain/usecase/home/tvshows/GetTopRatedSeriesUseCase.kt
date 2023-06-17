package com.red_velvet.flix.domain.usecase.home.tvshows

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import com.red_velvet.flix.domain.usecase.FormatMediaDateAndCountryCodeUsecase
import com.red_velvet.flix.domain.usecase.cachingTimeStamps.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopRatedSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase,
    private val formatMediaDateAndCountryCodeUsecase: FormatMediaDateAndCountryCodeUsecase,
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        if (shouldCacheApiResponseUseCase("top_rated_series")) {
            refreshLocalTopRatedSeries()
        }
        return seriesRepository.getLocalTopRatedSeries()
    }

    private suspend fun getTopRatedSeries(): List<SeriesEntity> {
        return seriesRepository.getTopRatedSeries().map {
            it.copy(
                formattedDate = formatMediaDateAndCountryCodeUsecase.getFormattedSeriesDate(
                    it.firstAirDate
                ),
            )
        }
    }

    private suspend fun refreshLocalTopRatedSeries() {
        val topRatedSeries = getTopRatedSeries()
        seriesRepository.cacheTopRatedSeries(topRatedSeries)
    }

}