package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.model.series.TVShow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.red_velvet.flix.domain.mapper.series.toPopularTvShowModelList
import javax.inject.Inject

class GetPopularTvShowUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend fun getPopularTvShow(): Flow<List<TVShow>> {
        return tvShowsRepository.getPopularTvShow().map {
            it.toPopularTvShowModelList()
        }
    }
}