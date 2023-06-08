package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetEpisodeVideosUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): List<TrailerEntity> {
        return seriesRepository.getEpisodeTrailers(seriesId, seasonNumber, episodeNumber)
    }
}