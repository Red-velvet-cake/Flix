package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.Trailer
import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetTVShowVideosUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int): List<Trailer> {
        return tvShowsRepository.getTVShowVideos(seriesId)
    }
}