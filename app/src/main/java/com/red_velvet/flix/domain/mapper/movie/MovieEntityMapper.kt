package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import com.red_velvet.flix.domain.model.movie.MovieEntity

fun PopularMovieDto.toModel(): MovieEntity {
    return MovieEntity(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun UpcomingMovieDto.toModel(): MovieEntity {
    return MovieEntity(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun TopRatedMovieDto.toModel(): MovieEntity {
    return MovieEntity(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun NowPlayingMovieDto.toModel(): MovieEntity {
    return MovieEntity(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0
    )
}

fun List<PopularMovieDto>.toPopularMoviesModels(): List<MovieEntity> {
    return map { it.toModel() }
}

fun List<UpcomingMovieDto>.toUpcomingMoviesModels(): List<MovieEntity> {
    return map { it.toModel() }
}

fun List<TopRatedMovieDto>.toTopRatedMoviesModels(): List<MovieEntity> {
    return map { it.toModel() }
}

fun List<NowPlayingMovieDto>.toNowPlayingMoviesModels(): List<MovieEntity> {
    return map { it.toModel() }
}