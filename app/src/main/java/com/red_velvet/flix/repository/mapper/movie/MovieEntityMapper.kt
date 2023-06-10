package com.red_velvet.flix.repository.mapper.movie

import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import com.red_velvet.flix.domain.entity.movie.MovieEntity

fun MovieEntity.toPopularMovieDto(): PopularMovieDto {
    return PopularMovieDto(
        id = id.toLong(),
        title = title,
        originalLanguage = "en-Us",
        overview = "overview",
        imageUrl = imageUrl,
        date = releaseDate,
    )
}

fun List<MovieEntity>.toPopularMovieDto(): List<PopularMovieDto> {
    return map { it.toPopularMovieDto() }
}

fun MovieEntity.toNowPlayingMovieDto(): NowPlayingMovieDto {
    return NowPlayingMovieDto(
        id = id.toLong(),
        title = title,
        originalLanguage = "en-Us",
        overview = "overview",
        imageUrl = imageUrl,
        date = releaseDate,
    )
}

fun List<MovieEntity>.toNowPlayingMovieDto(): List<NowPlayingMovieDto> {
    return map { it.toNowPlayingMovieDto() }
}

fun MovieEntity.toTopRatedMovieDto(): TopRatedMovieDto {
    return TopRatedMovieDto(
        id = id.toLong(),
        title = title,
        originalLanguage = "en-Us",
        overview = "overview",
        imageUrl = imageUrl,
        date = releaseDate,
    )
}

fun List<MovieEntity>.toTopRatedMovieDto(): List<TopRatedMovieDto> {
    return map { it.toTopRatedMovieDto() }
}

fun MovieEntity.toUpComingMovieDto(): UpcomingMovieDto {
    return UpcomingMovieDto(
        id = id.toLong(),
        title = title,
        originalLanguage = "en-Us",
        overview = "overview",
        imageUrl = imageUrl,
        date = releaseDate,
    )
}

fun List<MovieEntity>.toUpComingMovieDto(): List<UpcomingMovieDto> {
    return map { it.toUpComingMovieDto() }
}