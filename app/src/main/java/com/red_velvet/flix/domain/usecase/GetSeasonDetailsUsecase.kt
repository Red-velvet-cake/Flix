package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.model.series.Season
import javax.inject.Inject

class GetSeasonDetailsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int, seasonNumber: Int): Season {
        return tvShowsRepository.getSeasonDetails(seriesId, seasonNumber)
    }
}