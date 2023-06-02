package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.mapper.series.toModel
import com.red_velvet.flix.domain.model.series.Episode
import javax.inject.Inject

class GetEpisodeDetailsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int, episodeNumber: Int): Episode {
        return tvShowsRepository.getEpisodeDetails(
            seriesId,
            seasonNumber,
            episodeNumber
        ).toModel()
    }
}