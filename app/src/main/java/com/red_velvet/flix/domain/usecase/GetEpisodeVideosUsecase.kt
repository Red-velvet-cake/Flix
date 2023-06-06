package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.TrailerEntity
import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetEpisodeVideosUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): List<TrailerEntity> {
        return tvShowsRepository.getEpisodeVideos(seriesId, seasonNumber, episodeNumber)
    }
}