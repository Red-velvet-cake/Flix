package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.ui.base.BaseUiState

data class HomeUiState(
    val popularMovies: List<MediaUiState> = emptyList(),
    val nowPlayingMovies: List<MediaUiState> = emptyList(),
    val upcomingMovies: List<MediaUiState> = emptyList(),
    val topRatedMovies: List<MediaUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: List<String> = emptyList(),
) : BaseUiState {

    data class HomeItem(
        val title: String = "",
        val movies: List<MediaUiState> = emptyList(),
    )

    data class MediaUiState(
        val id: Int = 0,
        val imageUrl: String = "",
        val title: String = "",
        val date: String = "",
    )
}

internal fun List<Movie>.toUiState(): List<HomeUiState.MediaUiState> {
    return map {
        HomeUiState.MediaUiState(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            date = it.releaseDate
        )
    }
}