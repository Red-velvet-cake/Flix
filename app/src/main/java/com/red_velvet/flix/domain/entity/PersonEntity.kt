package com.red_velvet.flix.domain.entity

import android.media.Image

data class PersonEntity(
    val name: String,
    val id: Int,
    val imageUrl: String,
    val popularity: Double,
    val birthday: String
)