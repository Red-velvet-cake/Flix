package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto
import com.red_velvet.flix.domain.model.series.TVShow

fun PopularSeriesDto.toModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun TopRatedSeriesDto.toModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}


fun AiringTodaySeriesDto.toModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun OnTheAirSeriesDto.toModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun List<PopularSeriesDto>.toPopularTVShowsModels(): List<TVShow> {
    return map { it.toModel() }
}

fun List<TopRatedSeriesDto>.toTopRatedTVShowsModels(): List<TVShow> {
    return map { it.toModel() }
}

fun List<AiringTodaySeriesDto>.toAiringTodayTvShowsModels(): List<TVShow> {
    return map { it.toModel() }
}

fun List<OnTheAirSeriesDto>.toOnTheAirTvShowsModels(): List<TVShow> {
    return map { it.toModel() }
}