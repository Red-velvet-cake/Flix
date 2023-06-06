package com.red_velvet.flix.domain.model.movie


data class MovieEntity(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val popularity: Double,
    val releaseDate: String,
    val voteAverage: Double,
)