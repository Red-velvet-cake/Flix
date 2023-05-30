package com.red_velvet.flix.domain.model


data class Episode(
    val id: Int,
    val imageUrl: String,
    val episodeNumber: Int,
    val name: String,
    val overview: String,
    val runtime: Int,
    val seasonNumber: Int,
    val voteAverage: Double,
)