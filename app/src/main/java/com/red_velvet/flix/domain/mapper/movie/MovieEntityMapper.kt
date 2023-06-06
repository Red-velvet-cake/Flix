package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import com.red_velvet.flix.domain.model.movie.Movie

fun PopularMovieDto.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun UpcomingMovieDto.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun TopRatedMovieDto.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun NowPlayingMovieDto.toModel(): Movie {
    return Movie(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun List<PopularMovieDto>.toPopularMoviesModels(): List<Movie> {
    return map { it.toModel() }
}

fun List<UpcomingMovieDto>.toUpcomingMoviesModels(): List<Movie> {
    return map { it.toModel() }
}

fun List<TopRatedMovieDto>.toTopRatedMoviesModels(): List<Movie> {
    return map { it.toModel() }
}

fun List<NowPlayingMovieDto>.toNowPlayingMoviesModels(): List<Movie> {
    return map { it.toModel() }
}