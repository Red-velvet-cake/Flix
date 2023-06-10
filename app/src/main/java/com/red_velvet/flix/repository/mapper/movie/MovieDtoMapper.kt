package com.red_velvet.flix.repository.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import com.red_velvet.flix.domain.entity.movie.MovieEntity

fun PopularMovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0,
        originalLanguage = originalLanguage
    )
}

fun UpcomingMovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0,
        originalLanguage = originalLanguage
    )
}

fun TopRatedMovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0,
        originalLanguage = originalLanguage
    )
}

fun NowPlayingMovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id.toInt(),
        title = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        popularity = 0.0,
        releaseDate = date,
        voteAverage = 0.0,
        originalLanguage = originalLanguage
    )
}

fun List<PopularMovieDto>.toPopularMoviesEntity(): List<MovieEntity> {
    return map { it.toEntity() }
}

fun List<UpcomingMovieDto>.toUpcomingMoviesEntity(): List<MovieEntity> {
    return map { it.toEntity() }
}

fun List<TopRatedMovieDto>.toTopRatedMoviesEntity(): List<MovieEntity> {
    return map { it.toEntity() }
}

fun List<NowPlayingMovieDto>.toNowPlayingMoviesEntity(): List<MovieEntity> {
    return map { it.toEntity() }
}