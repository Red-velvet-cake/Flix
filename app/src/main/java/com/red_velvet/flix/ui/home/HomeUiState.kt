package com.red_velvet.flix.ui.home

import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState

data class HomeUiState(
    val popularMovies: List<MediaUiState> = emptyList(),
    val nowPlayingMovies: List<MediaUiState> = emptyList(),
    val upcomingMovies: List<MediaUiState> = emptyList(),
    val topRatedMovies: List<MediaUiState> = emptyList(),
    val isMovieLoading: Boolean = false,
    val movieError: ErrorUiState? = null,
    val popularSeries: List<MediaUiState> = emptyList(),
    val airingTodaySeries: List<MediaUiState> = emptyList(),
    val onTVSeries: List<MediaUiState> = emptyList(),
    val topRatedSeries: List<MediaUiState> = emptyList(),
    val isSeriesLoading: Boolean = false,
    val seriesError: ErrorUiState? = null

    ) : BaseUiState {

    data class HomeItem(
        val title: String = "",
        val items: List<MediaUiState> = emptyList(),
    )

    data class MediaUiState(
        val id: Int = 0,
        val imageUrl: String = "",
        val title: String = "",
        val date: String = "",
        val originalLanguage: String = "",
        val popularity: Double = 0.0,
        val voteAverage: Double = 0.0,
    )
}

