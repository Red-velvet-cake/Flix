package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.tv_show.EpisodeResource
import com.red_velvet.flix.domain.model.series.Episode
import com.red_velvet.flix.domain.utils.orZero

fun EpisodeResource.toModel(): Episode {
    return Episode(
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