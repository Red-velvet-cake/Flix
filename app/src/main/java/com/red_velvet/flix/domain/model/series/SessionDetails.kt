package com.red_velvet.flix.domain.model.series

import com.red_velvet.flix.data.remote.dtos.tv_show.EpisodeDto

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
