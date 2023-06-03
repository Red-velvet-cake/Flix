package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.mapper.series.toModel
import javax.inject.Inject

class GetSeasonImagesUseCase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int): List<String> {
        return tvShowsRepository.getSeasonImages(seriesId, seasonNumber).toModel()
    }
}