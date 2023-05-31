package com.red_velvet.flix.domain.model.series

import com.red_velvet.flix.domain.model.Episode


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