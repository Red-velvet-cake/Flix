package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.tv_show.TvShowDetailsDto
import com.red_velvet.flix.domain.model.series.TvShowDetails
import com.red_velvet.flix.domain.utils.orFalse
import com.red_velvet.flix.domain.utils.orZero

fun TvShowDetailsDto.toModel(): TvShowDetails {
    return TvShowDetails(
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
        seasons = seasons?.map { it.toModel() }.toList(),
        type = type.orEmpty(),
        voteAverage = voteAverage.orZero()
    )
}