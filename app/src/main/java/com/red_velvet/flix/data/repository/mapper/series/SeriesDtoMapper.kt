package com.red_velvet.flix.data.repository.mapper.series

import com.red_velvet.flix.data.local.database.entity.FavoriteSeriesDto
import com.red_velvet.flix.data.local.database.entity.WatchedSeriesDto
import com.red_velvet.flix.domain.model.movie.Movie

/*
* Later on, we will change data classes names to avoid confusion
* MovieDto (API) -> MovieResource
* MovieEntity (Database) -> MovieDto
* Movie (Domain) -> MovieEntity
* */


fun FavoriteSeriesDto.toFavoriteSeriesEntity(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = imageUrl,
        popularity = popularity,
        releaseDate = releaseDate,
        voteAverage = rating
    )
}

fun List<FavoriteSeriesDto>.toFavoriteSeriesEntityList(): List<Movie> {
    return map { it.toFavoriteSeriesEntity() }
}

fun WatchedSeriesDto.toWatchedSeriesEntity(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = imageUrl,
        popularity = popularity,
        releaseDate = releaseDate,
        voteAverage = rating
    )
}

fun List<WatchedSeriesDto>.toWatchedSeriesEntityList(): List<Movie> {
    return map { it.toWatchedSeriesEntity() }
}