package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.model.Trailer
import javax.inject.Inject

class GetEpisodeVideosUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): List<Trailer> {
        return tvShowsRepository.getEpisodeVideos(seriesId, seasonNumber, episodeNumber)
    }
}