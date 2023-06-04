package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.model.series.TVShow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAiringTodayTvShowUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(): Flow<List<TVShow>> {
        return tvShowsRepository.getAiringTodayTvShow()
    }
}