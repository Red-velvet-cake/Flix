package com.red_velvet.flix.repository.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import com.red_velvet.flix.data.remote.recoures.movie.MovieResource
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.utils.orZero

fun MovieResource.toEntity(): MovieEntity {
    return MovieEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        popularity = popularity.orZero(),
        releaseDate = releaseDate.orEmpty(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<MovieResource>?.toEntity(): List<MovieEntity> {
    return this?.map { it.toEntity() } ?: emptyList()
}

fun MovieResource.toPopularMovieDto(): PopularMovieDto {
    return PopularMovieDto(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>?.toPopularMovieDto(): List<PopularMovieDto> {
    return this?.map { it.toPopularMovieDto() } ?: emptyList()
}


fun MovieResource.toUpcomingMovieDto(): UpcomingMovieDto {
    return UpcomingMovieDto(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>?.toUpcomingMovieDto(): List<UpcomingMovieDto> {
    return this?.map { it.toUpcomingMovieDto() } ?: emptyList()
}

fun MovieResource.toTopRatedMovieDto(): TopRatedMovieDto {
    return TopRatedMovieDto(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>?.toTopRatedMovieDto(): List<TopRatedMovieDto> {
    return this?.map { it.toTopRatedMovieDto() } ?: emptyList()
}

fun MovieResource.toNowPlayingMovieDto(): NowPlayingMovieDto {
    return NowPlayingMovieDto(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>?.toNowPlayingMovieDto(): List<NowPlayingMovieDto> {
    return this?.map { it.toNowPlayingMovieDto() } ?: emptyList()
}