package com.red_velvet.flix.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watched_series")
data class WatchedSeriesDto(
    @PrimaryKey val id: Long,
    val title: String,
    val imageUrl: String,
    val popularity: Double,
    val releaseDate: String,
    val rating: Double,
)