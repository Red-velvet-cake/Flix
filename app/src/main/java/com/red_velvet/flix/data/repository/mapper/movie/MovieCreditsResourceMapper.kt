package com.red_velvet.flix.data.repository.mapper.movie

import com.red_velvet.flix.data.remote.recoures.person.MovieActorResource
import com.red_velvet.flix.domain.entity.movie.MovieCastEntity

fun MovieActorResource.toMovieCastEntity(): MovieCastEntity{
    return MovieCastEntity(
        name = name.orEmpty(),
        imageUrl = profilePath.orEmpty()
    )
}
fun List<MovieActorResource>?.toMovieCastEntity(): List<MovieCastEntity>{
    return this?.map { it.toMovieCastEntity() }?: emptyList()
}