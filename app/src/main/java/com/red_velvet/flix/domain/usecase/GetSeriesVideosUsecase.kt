package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.TrailerEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeriesVideosUsecase @Inject constructor(private val seriesRepository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int): List<TrailerEntity> {
        return seriesRepository.getSeriesVideos(seriesId)
    }
}