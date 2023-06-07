package com.red_velvet.flix.domain.entity.series

data class SessionDetailsEntity(
    val airDate: String,
    val episodes: List<EpisodeEntity>,
    val id: String,
    val seasonId: Int,
    val name: String,
    val overview: String,
    val imageUrl: String,
    val seasonNumber: Int
)
