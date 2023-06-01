package com.red_velvet.flix.domain.model.series


data class Images(
    val backdrops: List<Image>,
    val id: Int?,
    val posters: List<Image>,
    val stills: List<Image>
)