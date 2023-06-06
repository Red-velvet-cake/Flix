package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.tv_show.SessionDetailsResource
import com.red_velvet.flix.domain.model.series.SessionDetailsEntity
import com.red_velvet.flix.domain.utils.orZero

fun SessionDetailsResource.toModel(): SessionDetailsEntity {
    return SessionDetailsEntity(
        airDate = airDate.orEmpty(),
        episodes = episodes?.map { it?.toModel()!! }.orEmpty(),
        id = id.orEmpty(),
        seasonId = seasonId.orZero(),
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        seasonNumber = seasonNumber.orZero()
    )
}

