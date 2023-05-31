package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.remote.dtos.PaginationDto
import com.red_velvet.flix.data.remote.dtos.tv_show.TVShowDto
import kotlinx.coroutines.flow.Flow

class SeriesRepositoryImp : SeriesRepository {
    override suspend fun getOnTheAirSeries(): Flow<PaginationDto<TVShowDto>> {
        TODO("Not yet implemented")
    }
}