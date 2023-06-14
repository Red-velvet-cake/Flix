package com.red_velvet.flix.domain.entity.movie


data class MovieDetailsEntity(
    val id: Int,
    val imageUrl: String,
    val adult: Boolean,
    val genres: List<String>,
    val imdbId: String,
    val overview: String,
    val date: String,
    val runtime: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val language : String,
    val status : String,
    val productionCountry : String,
)