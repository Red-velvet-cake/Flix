package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.ui.home.homeUiState.MediaUiState

fun List<MovieEntity>.toUiState(): List<MediaUiState> {
    return map {
        MediaUiState(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            date = it.releaseDate
        )
    }
}