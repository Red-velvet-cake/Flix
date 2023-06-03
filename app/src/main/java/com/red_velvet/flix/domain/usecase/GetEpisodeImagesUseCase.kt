package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.mapper.series.toModel
import javax.inject.Inject

class GetEpisodeImagesUseCase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int, episodeNumber: Int): List<String> {
        return tvShowsRepository.getEpisodeImages(
            seriesId,
            seasonNumber,
            episodeNumber
        ).toModel()
    }
}