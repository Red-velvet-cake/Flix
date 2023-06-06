package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto
import com.red_velvet.flix.domain.entity.series.SeriesEntity

fun PopularSeriesDto.toModel(): SeriesEntity {
    return SeriesEntity(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun TopRatedSeriesDto.toModel(): SeriesEntity {
    return SeriesEntity(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}


fun AiringTodaySeriesDto.toModel(): SeriesEntity {
    return SeriesEntity(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun OnTheAirSeriesDto.toModel(): SeriesEntity {
    return SeriesEntity(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun List<PopularSeriesDto>.toPopularTVShowsModels(): List<SeriesEntity> {
    return map { it.toModel() }
}

fun List<TopRatedSeriesDto>.toTopRatedTVShowsModels(): List<SeriesEntity> {
    return map { it.toModel() }
}

fun List<AiringTodaySeriesDto>.toAiringTodayTvShowsModels(): List<SeriesEntity> {
    return map { it.toModel() }
}

fun List<OnTheAirSeriesDto>.toOnTheAirTvShowsModels(): List<SeriesEntity> {
    return map { it.toModel() }
}