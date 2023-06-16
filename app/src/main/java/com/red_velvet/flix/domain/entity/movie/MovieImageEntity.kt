package com.red_velvet.flix.domain.entity.movie

data class MovieImageEntity(
    val aspectRatio: Double,
    val filePath: String,
    val height: Int,
    val iso6391: String,
    val voteAverage: Double,
    val voteCount: Int,
    val width: Int
)