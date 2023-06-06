package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.series.SeasonEntity
import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetSeasonDetailsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int): SeasonEntity {
        return tvShowsRepository.getSeasonDetails(seriesId, seasonNumber)
    }
}