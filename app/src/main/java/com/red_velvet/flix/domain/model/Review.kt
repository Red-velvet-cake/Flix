package com.red_velvet.flix.domain.model

import com.red_velvet.flix.domain.model.movie.AuthorDetails


data class Review(
    val id: String,
    val author: AuthorDetails,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
    val imageUrl: String,
    val rating: Int,
    val username: String
)