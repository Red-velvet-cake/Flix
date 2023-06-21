package com.red_velvet.flix.ui.utils

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.ui.home.HomeUiState

internal fun List<MovieEntity>.toMovieUiState(): List<HomeUiState.MediaUiState> {
    return map {
        HomeUiState.MediaUiState(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            date = it.releaseDate,
            originalLanguage = it.originalLanguage,
            formattedDate = it.formattedDate,
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
            formattedDate = it.formattedDate,
        )
    }
}
