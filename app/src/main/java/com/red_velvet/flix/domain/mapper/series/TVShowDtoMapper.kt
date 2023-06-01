package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.tv_show.TVShowDto
import com.red_velvet.flix.domain.model.series.TVShow
import com.red_velvet.flix.domain.utils.orZero

fun TVShowDto.toModel(): TVShow {
    return TVShow(
        id = id.orZero(),
        name = name.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        firstAirDate = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

