package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.TVShowsRepository
import com.red_velvet.flix.domain.model.Review
import com.red_velvet.flix.domain.model.series.TVShow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTVShowReviewsUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend fun getTopRatedTvShow(): List<Review> {
        return tvShowsRepository.getTVShowReviews().map {
            it.toModel()
        }
    }
}