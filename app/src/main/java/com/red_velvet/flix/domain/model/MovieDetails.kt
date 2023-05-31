package com.red_velvet.flix.domain.model


data class MovieDetails(
    val id: Int,
    val imageUrl: String,
    val adult: Boolean,
    val genres: String,
    val imdbId: String,
    val overview: String,
    val date: String,
    val runtime: Int,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
)