package com.red_velvet.flix.data.repository.mapper

import com.red_velvet.flix.data.remote.recoures.trailer.TrailerDetailsResource
import com.red_velvet.flix.data.remote.recoures.trailer.TrailersResource
import com.red_velvet.flix.domain.entity.TrailerEntity

fun TrailersResource.toEntity(): List<TrailerEntity> {
    return results?.map { it?.toEntity()!! } ?: emptyList()
}

fun TrailerDetailsResource.toEntity(): TrailerEntity {
    return TrailerEntity(
        id = id.orEmpty(),
        key = key.orEmpty(),
        name = name.orEmpty(),
        site = site.orEmpty(),
    )
}
