package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.domain.model.movie.Movie

fun PopularMovieEntity.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun UpcomingMovieEntity.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun TopRatedMovieEntity.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun NowPlayingMovieEntity.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun List<PopularMovieEntity>.toModel(): List<Movie> {
    return map { it.toModel() }
}

fun List<UpcomingMovieEntity>.toModel(): List<Movie> {
    return map { it.toModel() }
}

fun List<TopRatedMovieEntity>.toModel(): List<Movie> {
    return map { it.toModel() }
}

fun List<NowPlayingMovieEntity>.toModel(): List<Movie> {
    return map { it.toModel() }
}