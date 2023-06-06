package com.red_velvet.flix.domain.model.series

data class SessionDetails(
    val airDate: String,
    val episodes: List<Episode>,
    val id: String,
    val seasonId: Int,
    val name: String,
    val overview: String,
    val imageUrl: String,
    val seasonNumber: Int
)
