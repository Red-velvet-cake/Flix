package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.series.SeriesDetailsResource
import com.red_velvet.flix.domain.entity.series.SeriesDetailsEntity
import com.red_velvet.flix.domain.utils.orFalse
import com.red_velvet.flix.domain.utils.orZero

fun SeriesDetailsResource.toModel(): SeriesDetailsEntity {
    return SeriesDetailsEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        adult = adult.orFalse(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        firstAirDate = firstAirDate.orEmpty(),
        genres = genres?.joinToString { it?.name.orEmpty() }.orEmpty(),
        numberOfEpisodes = numberOfEpisodes.orZero(),
        numberOfSeasons = numberOfSeasons.orZero(),
        overview = overview.orEmpty(),
        popularity = popularity.orZero(),
        seasons = seasons?.map { it?.toModel()!! }.orEmpty(),
        type = type.orEmpty(),
        voteAverage = voteAverage.orZero()
    )
}