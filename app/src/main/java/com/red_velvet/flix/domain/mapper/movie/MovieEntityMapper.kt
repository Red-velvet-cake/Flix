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
        voteAverage = 0.0,
        originalLanguage = originalLanguage
    )
}

fun UpcomingMovieEntity.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0,
        originalLanguage = originalLanguage
    )
}

fun TopRatedMovieEntity.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0,
        originalLanguage = originalLanguage
    )
}

fun NowPlayingMovieEntity.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0,
        originalLanguage = originalLanguage
    )
}

fun List<PopularMovieEntity>.toPopularMoviesModels(): List<Movie> {
    return map { it.toModel() }
}

fun List<UpcomingMovieEntity>.toUpcomingMoviesModels(): List<Movie> {
    return map { it.toModel() }
}

fun List<TopRatedMovieEntity>.toTopRatedMoviesModels(): List<Movie> {
    return map { it.toModel() }
}

fun List<NowPlayingMovieEntity>.toNowPlayingMoviesModels(): List<Movie> {
    return map { it.toModel() }
}