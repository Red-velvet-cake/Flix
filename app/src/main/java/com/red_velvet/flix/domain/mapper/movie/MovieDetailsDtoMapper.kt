package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.movie.MovieDetailsResource
import com.red_velvet.flix.domain.entity.movie.MovieDetailsEntity
import com.red_velvet.flix.domain.utils.orFalse
import com.red_velvet.flix.domain.utils.orZero

fun MovieDetailsResource.toModel(): MovieDetailsEntity {
    return MovieDetailsEntity(
        id = id.orZero(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + backdropPath,
        adult = adult.orFalse(),
        genres = genres?.joinToString { it?.name.orEmpty() }.orEmpty(),
        imdbId = imdbId.orEmpty(),
        overview = overview.orEmpty(),
        date = releaseDate.orEmpty(),
        runtime = runtime.orZero(),
        title = title.orEmpty(),
        video = video.orFalse(),
        voteAverage = voteAverage.orZero(),
    )
}

