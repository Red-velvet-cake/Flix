package com.red_velvet.flix.domain.model


data class Season(
    val id: Int,
    val episodeCount: Int,
    val name: String,
    val overview: String,
    val imageUrl: String,
    val seasonNumber: Int,
    val airDate: String,
    val episodes: List<Episode>,
)