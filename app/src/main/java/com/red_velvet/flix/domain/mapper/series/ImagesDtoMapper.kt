package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.data.remote.dtos.image.ImageDto
import com.red_velvet.flix.data.remote.dtos.image.ImagesDto
import com.red_velvet.flix.domain.model.series.Image
import com.red_velvet.flix.domain.model.series.Images
import com.red_velvet.flix.domain.utils.orZero

fun ImagesDto.toModel(): Images {
    return Images(
        backdrops = backdrops?.map { it?.toModel()!! }.orEmpty(),
        id = id.orZero(),
        posters = posters?.map { it?.toModel()!! }.orEmpty(),
        stills = stills?.map { it?.toModel()!! }.orEmpty()
    )
}


fun ImageDto.toModel(): Image {
    return Image(
        aspectRatio = aspectRatio.orZero(),
        filePath = filePath.orEmpty(),
        height = height.orZero(),
        iso6391 = iso6391.orEmpty(),
        voteAverage = voteAverage.orZero(),
        voteCount = voteCount.orZero(),
        width = width.orZero()
    )
}




