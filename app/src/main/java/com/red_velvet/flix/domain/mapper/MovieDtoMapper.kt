package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.domain.model.Movie
import com.red_velvet.flix.domain.utils.orZero

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id.orZero(),
        title = title.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        popularity = popularity.orZero(),
        releaseDate = releaseDate.orEmpty(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<MovieDto>.toMovieList(): List<Movie> {
    return map { it.toMovie() }
}


fun MovieDto.toPopularMovieEntity(): PopularMovieEntity {
    return PopularMovieEntity(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieDto>.toPopularMovieEntityList(): List<PopularMovieEntity> {
    return map { it.toPopularMovieEntity() }
}


fun MovieDto.toUpcomingMovieEntity(): UpcomingMovieEntity {
    return UpcomingMovieEntity(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieDto>.toUpcomingMovieEntityList(): List<UpcomingMovieEntity> {
    return map { it.toUpcomingMovieEntity() }
}

fun MovieDto.toTopRatedMovieEntity(): TopRatedMovieEntity {
    return TopRatedMovieEntity(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieDto>.toTopRatedMovieEntityList(): List<TopRatedMovieEntity> {
    return map { it.toTopRatedMovieEntity() }
}