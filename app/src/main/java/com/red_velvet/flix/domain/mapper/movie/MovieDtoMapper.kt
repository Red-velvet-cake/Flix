package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.utils.orZero

fun MovieDto.toModel(): Movie {
    return Movie(
        id = id.orZero(),
        title = title.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        popularity = popularity.orZero(),
        releaseDate = releaseDate.orEmpty(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<MovieDto>.toModel(): List<Movie> {
    return map { it.toModel() }
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
