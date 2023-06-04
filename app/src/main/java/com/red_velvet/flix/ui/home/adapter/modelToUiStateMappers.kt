package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.ui.home.homeUiState.MediaUiState

fun List<Movie>.toUiState(): List<MediaUiState> {
    return map {
        MediaUiState(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            date = it.releaseDate
        )
    }
}