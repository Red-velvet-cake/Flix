package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.mapper.toModel
import com.red_velvet.flix.domain.model.Trailer
import javax.inject.Inject

class GetTVShowVideosUseCase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int): List<Trailer> {
        return tvShowsRepository.getTVShowVideos(seriesId)
            .toModel()
    }
}