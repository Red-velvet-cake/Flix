package com.red_velvet.flix.domain.entity.series


data class SeriesEntity(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val firstAirDate: String,
    val popularity: Double,
    val voteAverage: Double,
    val formattedDate: String,
    )