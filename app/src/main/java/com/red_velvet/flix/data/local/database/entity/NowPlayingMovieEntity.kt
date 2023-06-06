package com.red_velvet.flix.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "now_playing_movies")
data class NowPlayingMovieEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val originalLanguage: String,
    val overview: String,
    val imageUrl: String,
    val date: String,
)