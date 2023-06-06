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


fun FavoriteSeriesDto.toFavoriteSeriesEntity(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = imageUrl,
        popularity = popularity,
        firstAirDate = releaseDate,
        voteAverage = rating
    )
}

fun List<FavoriteSeriesDto>.toFavoriteSeriesEntityList(): List<TVShow> {
    return map { it.toFavoriteSeriesEntity() }
}

fun WatchedSeriesDto.toWatchedSeriesEntity(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = imageUrl,
        popularity = popularity,
        firstAirDate = releaseDate,
        voteAverage = rating
    )
}

fun List<WatchedSeriesDto>.toWatchedSeriesEntityList(): List<TVShow> {
    return map { it.toWatchedSeriesEntity() }
}