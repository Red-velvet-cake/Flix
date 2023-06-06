package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeasonImagesUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int): List<String> {
        return seriesRepository.getSeasonImages(seriesId, seasonNumber)
    }
}