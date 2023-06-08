package com.red_velvet.flix.repository.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto
import com.red_velvet.flix.data.remote.recoures.series.SeriesResource
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.utils.orZero

fun SeriesResource.toEntity(): SeriesEntity {
    return SeriesEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        firstAirDate = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<SeriesResource>?.toEntity(): List<SeriesEntity> {
    return this?.map { it.toEntity() } ?: emptyList()
}

fun SeriesResource.toPopularSeriesDto(): PopularSeriesDto {
    return PopularSeriesDto(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<SeriesResource>?.toPopularSeriesDto(): List<PopularSeriesDto> {
    return this?.map { it.toPopularSeriesDto() } ?: emptyList()
}

fun SeriesResource.toTopRatedSeriesDto(): TopRatedSeriesDto {
    return TopRatedSeriesDto(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<SeriesResource>?.toTopRatedSeriesDto(): List<TopRatedSeriesDto> {
    return this?.map { it.toTopRatedSeriesDto() } ?: emptyList()
}

fun SeriesResource.toAiringTodaySeriesDto(): AiringTodaySeriesDto {
    return AiringTodaySeriesDto(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()

    )
}

fun List<SeriesResource>?.toAiringTodaySeriesDto(): List<AiringTodaySeriesDto> {
    return this?.map { it.toAiringTodaySeriesDto() } ?: emptyList()
}

fun SeriesResource.toOnTheAirSeriesDto(): OnTheAirSeriesDto {
    return OnTheAirSeriesDto(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<SeriesResource>?.toOnTheAirSeriesDto(): List<OnTheAirSeriesDto> {
    return this?.map { it.toOnTheAirSeriesDto() } ?: emptyList()
}