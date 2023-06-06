package com.red_velvet.flix.data.local.database.entity

import androidx.room.Entity

@Entity(tableName = "watched_movies")
data class WatchedMovieDto(
    val id: Long,
    val title: String,
    val originalLanguage: String,
    val overview: String,
    val imageUrl: String,
    val date: String,
)