package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.dtos.trailer.TrailerDetailsDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import com.red_velvet.flix.domain.model.Trailer

fun TrailersDto.toModel(): List<Trailer> {
    return results?.map { it?.toModel()!! }.orEmpty()
}

fun TrailerDetailsDto.toModel(): Trailer {
    return Trailer(
        id = id.orEmpty(),
        key = key.orEmpty(),
        name = name.orEmpty(),
        site = site.orEmpty(),
    )
}