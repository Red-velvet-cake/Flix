package com.red_velvet.flix.data.repository.mapper.series

import com.red_velvet.flix.data.local.database.entity.FavoriteSeriesDto
import com.red_velvet.flix.data.local.database.entity.WatchedSeriesDto
import com.red_velvet.flix.domain.model.series.TVShow


/*
* Later on, we will change data classes names to avoid confusion
* MovieDto (API) -> MovieResource
* MovieEntity (Database) -> MovieDto
* Movie (Domain) -> MovieEntity
* */


fun TVShow.toFavoriteSeriesDto(): FavoriteSeriesDto {
    return FavoriteSeriesDto(
        id = id.toLong(),
        title = name,
        releaseDate = firstAirDate,
        popularity = popularity,
        imageUrl = imageUrl,
        rating = voteAverage,
    )
}

fun List<TVShow>.toFavoriteSeriesDtoList(): List<FavoriteSeriesDto> {
    return map { it.toFavoriteSeriesDto() }
}

fun TVShow.toWatchedSeriesDto(): WatchedSeriesDto {
    return WatchedSeriesDto(
        id = id.toLong(),
        title = name,
        releaseDate = firstAirDate,
        popularity = popularity,
        imageUrl = imageUrl,
        rating = voteAverage,
    )
}

fun List<TVShow>.toWatchedSeriesDtoList(): List<WatchedSeriesDto> {
    return map { it.toWatchedSeriesDto() }
}