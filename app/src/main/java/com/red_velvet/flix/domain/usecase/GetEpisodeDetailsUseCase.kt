package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.series.EpisodeEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetEpisodeDetailsUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): EpisodeEntity {
        return seriesRepository.getEpisodeDetails(seriesId, seasonNumber, episodeNumber)
    }
}