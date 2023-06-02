package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.mapper.series.toModel
import com.red_velvet.flix.domain.model.series.Images
import javax.inject.Inject

class GetEpisodeImagesUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int, episodeNumber: Int): Images {
        return tvShowsRepository.getEpisodeImages(
            seriesId,
            seasonNumber,
            episodeNumber
        ).toModel()
    }
}