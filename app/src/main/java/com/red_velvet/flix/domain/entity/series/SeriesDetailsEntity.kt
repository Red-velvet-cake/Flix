package com.red_velvet.flix.domain.entity.series


data class SeriesDetailsEntity(
    val id: Int,
    val name: String,
    val adult: Boolean,
    val imageUrl: String,
    val firstAirDate: String,
    val genres: String,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val overview: String,
    val popularity: Double,
    val seasons: List<SeasonEntity> = emptyList(),
    val type: String,
    val voteAverage: Int,
)