import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaUiState


fun Movie.toUiState(): MediaUiState {
    return MediaUiState(
        mediaID = id,
        mediaName = title,
        mediaImage = BuildConfig.IMAGE_BASE_PATH,
        mediaPopularity = popularity,
        mediaReleaseDate = releaseDate,
        mediaVoteAverage = voteAverage
    )

}