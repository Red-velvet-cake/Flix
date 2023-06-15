package com.red_velvet.flix.ui.movieDetails

import com.red_velvet.flix.domain.entity.movie.MovieDetailsEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.ui.base.BaseUiState

data class MovieUiState(
    val isLoading: Boolean = true,
    val errors: List<String> = emptyList(),
    val isFavorite: Boolean = false,
    val isSaved: Boolean = false,
    val goBack: Boolean = false,
    val watchTrailer: Boolean = false,
    val movieName: String = "",
    val imageUrl: String = "",
    val movieCategories: List<String> = emptyList(),
    val movieTime: String = "",
    val movieLanguage: String = "",
    val movieRating: Int = 0,
    val rateTheMovie: Boolean = false,
    val description: String = "",
    val seeAllCast: Boolean = false,
    val topCast: List<TopCast> = emptyList(),
    val status: String = "",
    val releasedDate: String = "",
    val productionCountries: String = "",
    val keyWords: List<String> = emptyList(),
    val seeAllSimilarMovies: Boolean = false,
    val similarMovies: List<MovieList> = emptyList(),
    val seeAllImagesBelongToMovie: Boolean = false,
    val imageBelongToMovie: List<String> = emptyList(),
    val latest: String = "",
    val seeAllReviews: Boolean = false,
    val review: List<MovieReview> = emptyList(),
    val seeAllRecommendations: Boolean = false,
    val movieRecommendations: List<MovieList> = emptyList(),
) : BaseUiState
{
    data class MovieList(
        val movieImageUrl: String,
        val movieName: String,
    )
}

data class TopCast(
    val actorImageUrl: String,
    val actorName: String,
)



data class MovieReview(
    val rating: Double,
    val movieReviewer: String,
    val movieReview: String,
)

/*data class MovieRecommendations(
    val recommendedMovieName: String,
    val recommendedMovieImageUrl: String,
)*/
fun MovieDetailsEntity.toUiState(): MovieUiState {
    return MovieUiState(
        movieName = title
    )
}

fun List<MovieEntity>.toListOfMovies(): List<MovieUiState.MovieList> {
    return map { it.toMoviesUiState() }
}

fun MovieEntity.toMoviesUiState(): MovieUiState.MovieList {
    return MovieUiState.MovieList(
        movieName = title,
        movieImageUrl = imageUrl
    )
}