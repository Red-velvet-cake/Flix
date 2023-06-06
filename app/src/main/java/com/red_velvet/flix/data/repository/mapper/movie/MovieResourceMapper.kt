package com.red_velvet.flix.data.repository.mapper.movie

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

fun List<MovieResource>.toEntity(): List<MovieEntity> {
    return map { it.toEntity() }
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

fun List<MovieResource>.toPopularMovieDto(): List<PopularMovieDto> {
    return map { it.toPopularMovieDto() }
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

fun List<MovieResource>.toUpcomingMovieDto(): List<UpcomingMovieDto> {
    return map { it.toUpcomingMovieDto() }
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

fun List<MovieResource>.toTopRatedMovieDto(): List<TopRatedMovieDto> {
    return map { it.toTopRatedMovieDto() }
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

fun List<MovieResource>.toNowPlayingMovieDto(): List<NowPlayingMovieDto> {
    return map { it.toNowPlayingMovieDto() }
}