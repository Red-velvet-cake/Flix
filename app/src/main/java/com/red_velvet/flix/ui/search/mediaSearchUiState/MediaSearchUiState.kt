package com.red_velvet.flix.ui.search.mediaSearchUiState

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.domain.model.movie.Movie
import kotlin.Error


data class MediaSearchUiState(
    val searchInput: String = "",
    val searchTypes: SearchTypes = SearchTypes.MOVIE,
    val searchResult: List<MediaUiState> = emptyList(),
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val error: List<Error> = emptyList()
)
internal fun Movie.toUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id,
        mediaName = title,
        mediaImage = BuildConfig.IMAGE_BASE_PATH,
        mediaPopularity = popularity,
        mediaReleaseDate = releaseDate,
        mediaVoteAverage = voteAverage
    )

}
