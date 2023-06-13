package com.red_velvet.flix.ui.search.mediaSearchUiState

import com.red_velvet.flix.domain.entity.PersonEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState


data class MediaSearchUiState(
    val searchInput: String = "",
    val searchTypes: SearchTypes = SearchTypes.ALL,
    val searchResult: List<Any> = emptyList(),
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val error: ErrorUiState? = null
) : BaseUiState

internal fun MovieEntity.toUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id,
        mediaName = title,
        mediaImage = imageUrl,
        mediaPopularity = popularity,
        mediaReleaseDate = releaseDate,
    )

}

internal fun PersonEntity.toUiState(): MediaUiState {
    return MediaUiState(
        mediaName = name,
        mediaID = id,
        mediaImage = imageUrl,
        mediaPopularity = popularity,
        mediaReleaseDate = birthday
    )
}

internal fun SeriesEntity.toUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id,
        mediaName = name,
        mediaImage = imageUrl,
        mediaPopularity = popularity,
        mediaReleaseDate = firstAirDate,

        )
}
