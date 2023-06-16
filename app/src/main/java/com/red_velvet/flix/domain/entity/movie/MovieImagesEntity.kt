package com.red_velvet.flix.domain.entity.movie

data class MovieImagesEntity(
    val backdrops: List<MovieImageEntity>,
    val id: Int?,
    val posters: List<MovieImageEntity>,
)