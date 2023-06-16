package com.red_velvet.flix.data.repository.mapper.movie

import com.red_velvet.flix.data.remote.recoures.image.ImageResource
import com.red_velvet.flix.data.remote.recoures.image.MovieImagesResource
import com.red_velvet.flix.domain.entity.movie.MovieImageEntity
import com.red_velvet.flix.domain.entity.movie.MovieImagesEntity
import com.red_velvet.flix.domain.utils.orZero




fun MovieImagesResource.toMovieImagesEntity(): MovieImagesEntity {
    return MovieImagesEntity(
        id = id.orZero(),
        backdrops = backdrops.orEmpty().map { it!!.toMovieImageEntity() },
        posters = posters.orEmpty().map { it!!.toMovieImageEntity() }
    )
}
fun ImageResource.toMovieImageEntity():MovieImageEntity{
    return MovieImageEntity(
          aspectRatio = aspectRatio.orZero(),
        voteAverage = voteAverage.orZero(),
        filePath = filePath.orEmpty(),
        height = height.orZero(),
        iso6391 = iso6391.orEmpty(),
        voteCount = voteCount.orZero(),
        width = width.orZero()
    )
}