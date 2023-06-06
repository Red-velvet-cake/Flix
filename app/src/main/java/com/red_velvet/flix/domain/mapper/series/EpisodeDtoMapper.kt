package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.series.EpisodeResource
import com.red_velvet.flix.domain.model.series.EpisodeEntity
import com.red_velvet.flix.domain.utils.orZero

fun EpisodeResource.toModel(): EpisodeEntity {
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