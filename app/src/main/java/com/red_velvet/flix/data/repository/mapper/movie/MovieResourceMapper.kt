package com.red_velvet.flix.data.repository.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.utils.orZero

/*
* Later on, we will change data classes names to avoid confusion
* MovieDto (API) -> MovieResource
* MovieEntity (Database) -> MovieDto
* Movie (Domain) -> MovieEntity
* */

fun MovieDto.toMovieEntity(): Movie {
    return Movie(
        id = id.orZero(),
        title = title.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        popularity = popularity.orZero(),
        releaseDate = releaseDate.orEmpty(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<MovieDto>.toMovieEntityList(): List<Movie> {
    return map { it.toMovieEntity() }
}