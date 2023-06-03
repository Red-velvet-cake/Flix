package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.mapper.series.toModel
import com.red_velvet.flix.domain.model.series.TVShow
import javax.inject.Inject

class GetLatestTVShowUseCase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(): TVShow {
        return tvShowsRepository.getLatestTVShow().toModel()
    }
}