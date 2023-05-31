package com.red_velvet.flix.domain.mapper.movie

import com.red_velvet.flix.data.remote.dtos.trailer.TrailerDetailsDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import com.red_velvet.flix.domain.model.movie.Trailer

fun TrailersDto.toTrailerList(): List<Trailer> {
    return results?.map { it?.toTrailerDetails()!! } ?: emptyList()
}

fun TrailerDetailsDto.toTrailerDetails(): Trailer {
    return Trailer(
        id = id.orEmpty(),
        key = key.orEmpty(),
        name = name.orEmpty(),
        site = site.orEmpty(),
    )
}