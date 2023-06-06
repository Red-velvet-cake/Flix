package com.red_velvet.flix.domain.entity.series


data class SeasonEntity(
    val id: Int,
    val episodeCount: Int,
    val name: String,
    val overview: String,
    val imageUrl: String,
    val seasonNumber: Int,
    val airDate: String,
)