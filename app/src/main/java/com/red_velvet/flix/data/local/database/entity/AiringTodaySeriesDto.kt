package com.red_velvet.flix.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AIRING_TODAY_SERIES")
data class AiringTodaySeriesDto(
    @PrimaryKey val id: Long,
    val title: String,
    val originalLanguage: String,
    val overview: String,
    val imageUrl: String,
    val date: String,
    val popularity: Double,
    val voteAverage: Double,
    val formattedDate: String,
    )
