package com.red_velvet.flix.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TOP_RATED_MOVIES")
data class TopRatedMovieDto(
    @PrimaryKey val id: Long,
    val title: String,
    val originalLanguage: String,
    val overview: String,
    val imageUrl: String,
    val date: String,
)
