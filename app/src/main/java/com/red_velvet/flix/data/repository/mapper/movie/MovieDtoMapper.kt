package com.red_velvet.flix.data.repository.mapper.movie

import com.red_velvet.flix.data.local.database.entity.FavoriteMovieDto
import com.red_velvet.flix.data.local.database.entity.WatchedMovieDto
import com.red_velvet.flix.domain.model.movie.Movie

fun FavoriteMovieDto.toFavoriteMovieEntity(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = imageUrl,
        popularity = popularity,
        releaseDate = releaseDate,
        voteAverage = rating
    )
}

fun List<FavoriteMovieDto>.toFavoriteMovieEntityList(): List<Movie> {
    return map { it.toFavoriteMovieEntity() }
}

fun WatchedMovieDto.toWatchedMovieEntity(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = imageUrl,
        popularity = popularity,
        releaseDate = releaseDate,
        voteAverage = rating
    )
}

fun List<WatchedMovieDto>.toWatchedMovieEntityList(): List<Movie> {
    return map { it.toWatchedMovieEntity() }
}