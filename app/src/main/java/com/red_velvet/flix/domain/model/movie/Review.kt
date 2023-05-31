package com.red_velvet.flix.domain.model.movie


data class Review(
    val id: String,
    val author: String,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
    val imageUrl: String,
    val rating: Int,
    val username: String
)