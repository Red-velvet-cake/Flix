package com.red_velvet.flix.domain.entity.series


data class ImagesEntity(
    val backdrops: List<ImageEntity>,
    val id: Int?,
    val posters: List<ImageEntity>,
    val stills: List<ImageEntity>
)