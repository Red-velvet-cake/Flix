package com.red_velvet.flix.repository.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.series.SessionDetailsResource
import com.red_velvet.flix.domain.entity.series.SessionDetailsEntity
import com.red_velvet.flix.domain.utils.orZero

fun SessionDetailsResource.toEntity(): SessionDetailsEntity {
    return SessionDetailsEntity(
        airDate = airDate.orEmpty(),
        episodes = episodes?.map { it?.toEntity()!! }.orEmpty(),
        id = id.orEmpty(),
        seasonId = seasonId.orZero(),
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        seasonNumber = seasonNumber.orZero()
    )
}