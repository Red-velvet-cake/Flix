package com.red_velvet.flix.ui.search.mediaSearchUiState

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState
import kotlin.Error


data class MediaSearchUiState (
    val searchInput: String = "",
    val searchTypes: SearchTypes = SearchTypes.ALL,
    val searchResult: List<MediaUiState> = emptyList(),
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
        mediaVoteAverage = voteAverage
    )

}
