package com.red_velvet.flix.data.repository.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.image.ImagesResource

fun ImagesResource.toEntity(): List<String> {
    return posters?.map {
        BuildConfig.IMAGE_BASE_PATH + it?.filePath
    }.orEmpty()
}