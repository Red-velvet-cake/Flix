package com.red_velvet.flix.domain.model.account

import com.red_velvet.flix.domain.model.movie.Movie

data class CustomListDetails(
    val createdBy: String,
    val description: String,
    val id: String,
    val items: List<Movie>,
    val name: String,
    val itemCount: Int,
)
