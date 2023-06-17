package com.red_velvet.flix.repository.mapper.series

import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto
import com.red_velvet.flix.domain.entity.series.SeriesEntity

fun SeriesEntity.toPopularSeriesDto(): PopularSeriesDto {
    return PopularSeriesDto(
        id = id.toLong(),
        title = name,
        originalLanguage = "en-US",
        overview = "overview",
        imageUrl = imageUrl,
        date = firstAirDate,
        popularity = popularity,
        voteAverage = voteAverage,
        formattedDate = formattedDate
    )
}

fun List<SeriesEntity>.toPopularSeriesDto(): List<PopularSeriesDto> {
    return map { it.toPopularSeriesDto() }
}

fun SeriesEntity.toTopRatedSeriesDto(): TopRatedSeriesDto {
    return TopRatedSeriesDto(
        id = id.toLong(),
        title = name,
        originalLanguage = "en-US",
        overview = "overview",
        imageUrl = imageUrl,
        date = firstAirDate,
        popularity = popularity,
        voteAverage = voteAverage,
        formattedDate = formattedDate
    )
}

fun List<SeriesEntity>.toTopRatedSeriesDto(): List<TopRatedSeriesDto> {
    return map { it.toTopRatedSeriesDto() }
}

fun SeriesEntity.toOnTheAirSeriesDto(): OnTheAirSeriesDto {
    return OnTheAirSeriesDto(
        id = id.toLong(),
        title = name,
        originalLanguage = "en-US",
        overview = "overview",
        imageUrl = imageUrl,
        date = firstAirDate,
        popularity = popularity,
        voteAverage = voteAverage,
        formattedDate = formattedDate
    )
}

fun List<SeriesEntity>.toOnTheAirSeriesDto(): List<OnTheAirSeriesDto> {
    return map { it.toOnTheAirSeriesDto() }
}

fun SeriesEntity.toAiringTodaySeriesDto(): AiringTodaySeriesDto {
    return AiringTodaySeriesDto(
        id = id.toLong(),
        title = name,
        originalLanguage = "en-US",
        overview = "overview",
        imageUrl = imageUrl,
        date = firstAirDate,
        popularity = popularity,
        voteAverage = voteAverage,
        formattedDate = formattedDate
    )
}

fun List<SeriesEntity>.toAiringTodaySeriesDto(): List<AiringTodaySeriesDto> {
    return map { it.toAiringTodaySeriesDto() }
}