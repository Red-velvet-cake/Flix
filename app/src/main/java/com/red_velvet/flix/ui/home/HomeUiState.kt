package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.ui.base.BaseUiState

data class HomeUiState(
    val popularMovies: List<MediaUiState> = emptyList(),
    val nowPlayingMovies: List<MediaUiState> = emptyList(),
    val upcomingMovies: List<MediaUiState> = emptyList(),
    val topRatedMovies: List<MediaUiState> = emptyList(),
    val isMovieLoading: Boolean = false,
    val movieError: List<String> = emptyList(),
    val popularSeries: List<MediaUiState> = emptyList(),
    val airingTodaySeries: List<MediaUiState> = emptyList(),
    val onTVSeries: List<MediaUiState> = emptyList(),
    val topRatedSeries: List<MediaUiState> = emptyList(),
    val isSeriesLoading: Boolean = false,
    val seriesError: List<String> = emptyList(),

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

internal fun List<MovieEntity>.toMovieUiState(): List<HomeUiState.MediaUiState> {
    return map {
        HomeUiState.MediaUiState(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            date = it.releaseDate,
            originalLanguage = it.originalLanguage,
        )
    }
}


internal fun List<SeriesEntity>.toSeriesUiState(): List<HomeUiState.MediaUiState> {
    return map {
        HomeUiState.MediaUiState(
            id = it.id,
            title = it.name,
            imageUrl = it.imageUrl,
            date = it.firstAirDate,
            popularity = it.popularity,
            voteAverage = it.voteAverage,
        )
    }
}
