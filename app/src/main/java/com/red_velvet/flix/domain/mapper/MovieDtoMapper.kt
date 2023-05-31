package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.BuildConfig
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

/*
* TODO: Taha Please Implement the following functions
* */

//fun MovieDto.toPopularMovieEntity(): PopularMovieEntity {}
//
//fun MovieDto.toUpcomingMovieEntity(): UpcomingMovieEntity {}
//
//fun MovieDto.toTopRatedMovieEntity(): TopRatedMovieEntity {}
//
//fun List<MovieDto>.toMovieList(): List<Movie> {
//    return map { it.toMovie() }
//}
//
//fun List<MovieDto>.toPopularMovieEntityList(): List<PopularMovieEntity> {
//    return map { it.toPopularMovieEntity() }
//}
//
//fun List<MovieDto>.toUpcomingMovieEntityList(): List<UpcomingMovieEntity> {
//    return map { it.toUpcomingMovieEntity() }
//}
//
//fun List<MovieDto>.toTopRatedMovieEntityList(): List<TopRatedMovieEntity> {
//    return map { it.toTopRatedMovieEntity() }
//}