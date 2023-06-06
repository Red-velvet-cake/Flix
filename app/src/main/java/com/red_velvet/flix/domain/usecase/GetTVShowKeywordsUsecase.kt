package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetTVShowKeywordsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(seriesId: Int): List<String> {
        return tvShowsRepository.getTVShowKeywords(seriesId)
    }
}