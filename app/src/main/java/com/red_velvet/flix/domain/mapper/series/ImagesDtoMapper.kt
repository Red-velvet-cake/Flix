package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.image.ImagesResource

fun ImagesResource.toModel(): List<String> {
    return posters?.map {
        BuildConfig.IMAGE_BASE_PATH + it?.filePath
    }.orEmpty()
}





