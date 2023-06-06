package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.dtos.movie.MovieResource
import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.utils.orZero

fun MovieResource.toModel(): Movie {
    return Movie(
        id = id.orZero(),
        title = title.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        popularity = popularity.orZero(),
        releaseDate = releaseDate.orEmpty(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<MovieResource>.toModel(): List<Movie> {
    return map { it.toModel() }
}

fun MovieResource.toPopularMovieEntity(): PopularMovieEntity {
    return PopularMovieEntity(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>.toPopularMovieEntityList(): List<PopularMovieEntity> {
    return map { it.toPopularMovieEntity() }
}


fun MovieResource.toUpcomingMovieEntity(): UpcomingMovieEntity {
    return UpcomingMovieEntity(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>.toUpcomingMovieEntityList(): List<UpcomingMovieEntity> {
    return map { it.toUpcomingMovieEntity() }
}

fun MovieResource.toTopRatedMovieEntity(): TopRatedMovieEntity {
    return TopRatedMovieEntity(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>.toTopRatedMovieEntityList(): List<TopRatedMovieEntity> {
    return map { it.toTopRatedMovieEntity() }
}

fun MovieResource.toNowPlayingMovieEntity(): NowPlayingMovieEntity {

    return NowPlayingMovieEntity(
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = releaseDate.orEmpty()
    )
}

fun List<MovieResource>.toNowPlayingMovieEntityList(): List<NowPlayingMovieEntity> {
    return map { it.toNowPlayingMovieEntity() }
}