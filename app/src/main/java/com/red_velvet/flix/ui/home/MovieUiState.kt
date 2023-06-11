package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.ui.base.BaseUiState

data class MovieUiState(
    val popularMovies: List<MediaUiState> = emptyList(),
    val nowPlayingMovies: List<MediaUiState> = emptyList(),
    val upcomingMovies: List<MediaUiState> = emptyList(),
    val topRatedMovies: List<MediaUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: List<String> = emptyList(),
) : BaseUiState {

    data class MovieTabItem(
        val title: String = "",
        val movies: List<MediaUiState> = emptyList(),
    )

    data class MediaUiState(
        val id: Int = 0,
        val imageUrl: String = "",
        val title: String = "",
        val date: String = "",
        val originalLanguage: String = "",

        )
}

internal fun List<MovieEntity>.toUiState(): List<MovieUiState.MediaUiState> {
    return map {
        MovieUiState.MediaUiState(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            date = it.releaseDate,
            originalLanguage = it.originalLanguage,
        )
    }
}

internal fun MovieEntity.toUiState(): MovieUiState.MediaUiState {
    return MovieUiState.MediaUiState(
        id = id,
        title = title,
        imageUrl = imageUrl,
        date = releaseDate,
        originalLanguage = originalLanguage
    )

}