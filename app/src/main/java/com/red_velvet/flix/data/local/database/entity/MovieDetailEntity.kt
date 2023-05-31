package com.red_velvet.flix.data.local.database.entity

data class MovieDetailEntity (
    val id : Long,
    val title : String,
    val overview : String,
    val videoUrl : String,
    val adult : Boolean,
        )