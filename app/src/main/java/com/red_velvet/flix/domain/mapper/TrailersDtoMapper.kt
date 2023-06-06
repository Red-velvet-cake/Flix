package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.dtos.trailer.TrailerDetailsResource
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersResource
import com.red_velvet.flix.domain.model.Trailer

fun TrailersResource.toModel(): List<Trailer> {
    return results?.map { it?.toModel()!! } ?: emptyList()
}

fun TrailerDetailsResource.toModel(): Trailer {
    return Trailer(
        id = id.orEmpty(),
        key = key.orEmpty(),
        name = name.orEmpty(),
        site = site.orEmpty(),
    )
}
