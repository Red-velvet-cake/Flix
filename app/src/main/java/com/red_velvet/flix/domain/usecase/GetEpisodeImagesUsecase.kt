package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import javax.inject.Inject

class GetEpisodeImagesUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int, episodeNumber: Int): List<String> {
        return tvShowsRepository.getEpisodeImages(seriesId, seasonNumber, episodeNumber)
    }
}