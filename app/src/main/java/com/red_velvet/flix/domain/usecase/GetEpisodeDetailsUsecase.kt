package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.series.EpisodeEntity
import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetEpisodeDetailsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int, episodeNumber: Int): EpisodeEntity {
        return tvShowsRepository.getEpisodeDetails(seriesId, seasonNumber, episodeNumber)
    }
}