package com.red_velvet.flix.domain.entity

import com.red_velvet.flix.domain.entity.movie.AuthorDetailsEntity


data class ReviewEntity(
    val id: Int,
    val author: AuthorDetailsEntity,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
    val imageUrl: String,
    val rating: Int,
    val username: String
)