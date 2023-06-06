package com.red_velvet.flix.domain.model

import com.red_velvet.flix.domain.model.movie.AuthorDetailsEntity


data class ReviewEntity(
    val id: String,
    val author: AuthorDetailsEntity,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
    val imageUrl: String,
    val rating: Int,
    val username: String
)