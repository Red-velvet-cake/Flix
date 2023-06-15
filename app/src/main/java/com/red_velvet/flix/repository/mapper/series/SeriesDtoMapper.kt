package com.red_velvet.flix.repository.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto
import com.red_velvet.flix.domain.entity.series.SeriesEntity

fun PopularSeriesDto.toEntity(): SeriesEntity {
    return SeriesEntity(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun TopRatedSeriesDto.toEntity(): SeriesEntity {
    return SeriesEntity(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}


fun AiringTodaySeriesDto.toEntity(): SeriesEntity {
    return SeriesEntity(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun OnTheAirSeriesDto.toEntity(): SeriesEntity {
    return SeriesEntity(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}

fun List<PopularSeriesDto>.toEntity(): List<SeriesEntity> {
    return map { it.toEntity() }
}

fun List<TopRatedSeriesDto>.toEntity(): List<SeriesEntity> {
    return map { it.toEntity() }
}

fun List<AiringTodaySeriesDto>.toEntity(): List<SeriesEntity> {
    return map { it.toEntity() }
}

fun List<OnTheAirSeriesDto>.toEntity(): List<SeriesEntity> {
    return map { it.toEntity() }
}