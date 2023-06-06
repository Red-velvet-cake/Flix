package com.red_velvet.flix.domain.entity.series


data class EpisodeEntity(
    val id: Int,
    val imageUrl: String,
    val episodeNumber: Int,
    val name: String,
    val overview: String,
    val runtime: Int,
    val seasonNumber: Int,
    val voteAverage: Double,
)