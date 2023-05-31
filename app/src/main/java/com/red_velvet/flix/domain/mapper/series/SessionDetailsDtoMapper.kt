package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.tv_show.SessionDetailsDto
import com.red_velvet.flix.domain.model.series.SessionDetails
import com.red_velvet.flix.domain.utils.orZero

fun SessionDetailsDto.toModel(): SessionDetails {
    return SessionDetails(
        airDate = airDate.orEmpty(),
        episodes = episodes?.map { it?.toModel() }.orEmpty(),
        id = id.orEmpty(),
        seasonId = seasonId.orZero(),
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        seasonNumber = seasonNumber.orZero()
    )
}

