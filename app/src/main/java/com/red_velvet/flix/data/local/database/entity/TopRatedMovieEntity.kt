package com.red_velvet.flix.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_rated_movies")
data class TopRatedMovieEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val originalLanguage: String,
    val overview: String,
    val imageUrl: String,
    val date: String,
)
