package com.red_velvet.flix.data.repository.mapper.movie

import com.red_velvet.flix.data.local.database.entity.FavoriteMovieDto
import com.red_velvet.flix.data.local.database.entity.WatchedMovieDto
import com.red_velvet.flix.domain.model.movie.Movie

/*
* Later on, we will change data classes names to avoid confusion
* MovieDto (API) -> MovieResource
* MovieEntity (Database) -> MovieDto
* Movie (Domain) -> MovieEntity
* */


fun Movie.toFavoriteMovieDto(): FavoriteMovieDto {
    return FavoriteMovieDto(
        id = id.toLong(),
        title = title,
        releaseDate = releaseDate,
        popularity = popularity,
        imageUrl = imageUrl,
        rating = voteAverage,
    )
}

fun List<Movie>.toFavoriteMovieDtoList(): List<FavoriteMovieDto> {
    return map { it.toFavoriteMovieDto() }
}

fun Movie.toWatchedMovieDto(): WatchedMovieDto {
    return WatchedMovieDto(
        id = id.toLong(),
        title = title,
        releaseDate = releaseDate,
        popularity = popularity,
        imageUrl = imageUrl,
        rating = voteAverage,
    )
}

fun List<Movie>.toWatchedMovieDtoList(): List<WatchedMovieDto> {
    return map { it.toWatchedMovieDto() }
}