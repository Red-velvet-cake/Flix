package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.ui.base.BaseUiState

data class TvShowUiState(
    val popularSeries: List<MediaUiState> = emptyList(),
    val airingTodaySeries: List<MediaUiState> = emptyList(),
    val onTVSeries: List<MediaUiState> = emptyList(),
    val topRatedSeries: List<MediaUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: List<String> = emptyList(),
) : BaseUiState {

    data class TvShowItem(
        val title: String = "",
        val tvshows: List<MediaUiState> = emptyList(),
    )

    data class MediaUiState(
        val id: Int = 0,
        val imageUrl: String = "",
        val title: String = "",
        val date: String = "",
        val popularity: Double = 0.0,
        val voteAverage: Double = 0.0,
    )
}

internal fun List<SeriesEntity>.toUiState(): List<TvShowUiState.MediaUiState> {
    return map {
        TvShowUiState.MediaUiState(
            id = it.id,
            title = it.name,
            imageUrl = it.imageUrl,
            date = it.firstAirDate,
            popularity = it.popularity,
            voteAverage = it.voteAverage,
        )
    }
}

internal fun SeriesEntity.toUiState(): TvShowUiState.MediaUiState {
    return TvShowUiState.MediaUiState(
        id = id,
        title = name,
        imageUrl = imageUrl,
        date = firstAirDate,
        popularity = popularity,
        voteAverage = voteAverage,
    )

}