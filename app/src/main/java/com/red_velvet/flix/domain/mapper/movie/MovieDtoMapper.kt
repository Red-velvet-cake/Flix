package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import com.red_velvet.flix.data.remote.recoures.movie.MovieResource
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.utils.orZero

fun MovieResource.toModel(): MovieEntity {
    return MovieEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        popularity = popularity.orZero(),
        releaseDate = releaseDate.orEmpty(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<MovieResource>.toModel(): List<MovieEntity> {
    return map { it.toModel() }
}

fun MovieResource.toPopularMovieEntity(): PopularMovieDto {
    return PopularMovieDto(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>.toPopularMovieEntityList(): List<PopularMovieDto> {
    return map { it.toPopularMovieEntity() }
}


fun MovieResource.toUpcomingMovieEntity(): UpcomingMovieDto {
    return UpcomingMovieDto(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>.toUpcomingMovieEntityList(): List<UpcomingMovieDto> {
    return map { it.toUpcomingMovieEntity() }
}

fun MovieResource.toTopRatedMovieEntity(): TopRatedMovieDto {
    return TopRatedMovieDto(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>.toTopRatedMovieEntityList(): List<TopRatedMovieDto> {
    return map { it.toTopRatedMovieEntity() }
}

fun MovieResource.toNowPlayingMovieEntity(): NowPlayingMovieDto {

    return NowPlayingMovieDto(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>.toNowPlayingMovieEntityList(): List<NowPlayingMovieDto> {
    return map { it.toNowPlayingMovieEntity() }
}