package com.red_velvet.flix.repository.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.series.EpisodeResource
import com.red_velvet.flix.domain.entity.series.EpisodeEntity
import com.red_velvet.flix.domain.utils.orZero

fun EpisodeResource.toEntity(): EpisodeEntity {
    return EpisodeEntity(
        id = id.orZero(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + stillPath,
        episodeNumber = episodeNumber.orZero(),
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        runtime = runtime.orZero(),
        seasonNumber = seasonNumber.orZero(),
        voteAverage = voteAverage.orZero(),
    )
}