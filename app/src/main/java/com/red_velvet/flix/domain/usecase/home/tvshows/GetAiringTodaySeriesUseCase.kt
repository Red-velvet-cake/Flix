package com.red_velvet.flix.domain.usecase.home.tvshows

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import com.red_velvet.flix.domain.usecase.FormatMediaDateAndCountryCodeUsecase
import com.red_velvet.flix.domain.usecase.cachingTimeStamps.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAiringTodaySeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase,
    private val formatMediaDateAndCountryCodeUsecase: FormatMediaDateAndCountryCodeUsecase,
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        if (shouldCacheApiResponseUseCase("airing_today_series")) {
            refreshLocalAiringTodaySeries()
        }
        return seriesRepository.getLocalAiringTodaySeries()
    }

    private suspend fun getAiringTodaySeries(): List<SeriesEntity> {
        return seriesRepository.getAiringTodaySeries().map {
            it.copy(
                formattedDate = formatMediaDateAndCountryCodeUsecase.getFormattedSeriesDate(
                    it.firstAirDate
                ),
            )
        }
    }

    private suspend fun refreshLocalAiringTodaySeries() {
        val airingTodaySeries = getAiringTodaySeries()
        seriesRepository.cacheAiringTodaySeries(airingTodaySeries)
    }

}