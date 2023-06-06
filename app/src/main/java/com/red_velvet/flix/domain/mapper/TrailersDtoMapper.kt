package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.recoures.trailer.TrailerDetailsResource
import com.red_velvet.flix.data.remote.recoures.trailer.TrailersResource
import com.red_velvet.flix.domain.entity.TrailerEntity

fun TrailersResource.toModel(): List<TrailerEntity> {
    return results?.map { it?.toModel()!! } ?: emptyList()
}

fun TrailerDetailsResource.toModel(): TrailerEntity {
    return TrailerEntity(
        id = id.orEmpty(),
        key = key.orEmpty(),
        name = name.orEmpty(),
        site = site.orEmpty(),
    )
}
