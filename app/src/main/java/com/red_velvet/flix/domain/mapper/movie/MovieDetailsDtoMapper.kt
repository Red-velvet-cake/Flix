package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.movie.MovieDetailsResource
import com.red_velvet.flix.domain.model.movie.MovieDetails
import com.red_velvet.flix.domain.utils.orFalse
import com.red_velvet.flix.domain.utils.orZero

fun MovieDetailsResource.toModel(): MovieDetails {
    return MovieDetails(
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

