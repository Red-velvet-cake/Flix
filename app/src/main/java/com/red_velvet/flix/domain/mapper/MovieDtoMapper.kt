package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.domain.model.Movie

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id ?: 0,
        title = title ?: "",
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        popularity = popularity ?: 0.0,
        releaseDate = releaseDate ?: "",
        voteAverage = voteAverage ?: 0.0
    )
}

fun List<MovieDto>.toMovieList(): List<Movie> {
    return map { it.toMovie() }
}


fun MovieDto.toPopularMovieEntity(): PopularMovieEntity {
    return PopularMovieEntity(
        id = (id ?: 0).toLong(),
        title = title ?: "",
        originalLanguage = originalLanguage ?: "",
        overview = overview ?: "",
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate ?: ""
    )
}

fun List<MovieDto>.toPopularMovieEntityList(): List<PopularMovieEntity> {
    return map { it.toPopularMovieEntity() }
}


fun MovieDto.toUpcomingMovieEntity(): UpcomingMovieEntity {
    return UpcomingMovieEntity(
        id = (id ?: 0).toLong(),
        title = title ?: "",
        originalLanguage = originalLanguage ?: "",
        overview = overview ?: "",
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate ?: ""
    )
}

fun List<MovieDto>.toUpcomingMovieEntityList(): List<UpcomingMovieEntity> {
    return map { it.toUpcomingMovieEntity() }
}

fun MovieDto.toTopRatedMovieEntity(): TopRatedMovieEntity {
    return TopRatedMovieEntity(
        id = (id ?: 0).toLong(),
        title = title ?: "",
        originalLanguage = originalLanguage ?: "",
        overview = overview ?: "",
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate ?: ""
    )
}

fun List<MovieDto>.toTopRatedMovieEntityList(): List<TopRatedMovieEntity> {
    return map { it.toTopRatedMovieEntity() }
}