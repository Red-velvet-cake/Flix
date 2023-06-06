package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.tv_show.SeasonResource
import com.red_velvet.flix.domain.model.series.Season
import com.red_velvet.flix.domain.utils.orZero

fun SeasonResource.toModel(): Season {
    return Season(
        id = id.orZero(),
        episodeCount = episodeCount.orZero(),
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        seasonNumber = seasonNumber.orZero(),
        airDate = airDate.orEmpty(),
    )
}