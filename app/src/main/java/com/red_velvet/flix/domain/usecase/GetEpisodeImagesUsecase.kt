package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetEpisodeImagesUsecase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): List<String> {
        return seriesRepository.getEpisodeImages(seriesId, seasonNumber, episodeNumber)
    }
}