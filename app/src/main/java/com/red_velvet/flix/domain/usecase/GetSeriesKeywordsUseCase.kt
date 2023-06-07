package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeriesKeywordsUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int): List<String> {
        return seriesRepository.getSeriesKeywords(seriesId)
    }
}