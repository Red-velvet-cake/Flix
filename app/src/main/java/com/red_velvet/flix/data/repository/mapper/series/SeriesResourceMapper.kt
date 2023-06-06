package com.red_velvet.flix.data.repository.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.tv_show.TVShowDto
import com.red_velvet.flix.domain.model.series.TVShow
import com.red_velvet.flix.domain.utils.orZero

/*
* Later on, we will change data classes names to avoid confusion
* MovieDto (API) -> MovieResource
* MovieEntity (Database) -> MovieDto
* Movie (Domain) -> MovieEntity
* */

fun TVShowDto.toSeriesEntity(): TVShow {
    return TVShow(
        id = id.orZero(),
        name = name.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        firstAirDate = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<TVShowDto>.toSeriesEntityList(): List<TVShow> {
    return map { it.toSeriesEntity() }
}