package com.red_velvet.flix.domain.model.series

import com.red_velvet.flix.domain.mapper.series.Image

data class Images(
    val backdrops: List<Image>,
    val id: Int?,
    val posters: List<Image>,
    val stills: List<Image>
)