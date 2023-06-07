package com.red_velvet.flix.ui.movieDetails

data class MovieUiState(
    val isLoading : Boolean = true,
    val errors : List<String> = emptyList(),
    val isFavorite: Boolean = false,
    val isSaved: Boolean = false,
    val goBack: Boolean = false,
    val watchTrailer: Boolean = false,
    val movieName: String = "",
    val imageUrl: String = "",
    val movieCategories: List<String> = emptyList(),
    val movieTime: String = "",
    val movieLanguage: String = "",
    val movieRating: Double = 0.0,
    val rateTheMovie: Boolean = false,
    val description: String = "",
    val seeAllCast: Boolean = false,
    val topCast: List<TopCast> = emptyList(),
    val status: String = "",
    val releasedDate: String = "",
    val productionCountries: String = "",
    val keyWords: List<String> = emptyList(),
    val seeAllSimilarMovies: Boolean = false,
    val similarMovies: List<SimilarMovie> = emptyList(),
    val seeAllImagesBelongToMovie: Boolean = false,
    val imageBelongToMovie: List<String> = emptyList(),
    val latest: String = "",
    val seeAllReviews: Boolean = false,
    val review: List<MovieReview> = emptyList(),
    val seeAllRecommendations: Boolean = false,
    val movieRecommendations: List<MovieRecommendations> = emptyList(),
)

data class TopCast(
    val actorImageUrl: String,
    val actorName: String,
)

data class SimilarMovie(
    val movieImageUrl: String,
    val movieName: String,
)

data class MovieReview(
    val rating: Double,
    val movieReviewer: String,
    val movieReview: String,
)

data class MovieRecommendations(
    val recommendedMovieName: String,
    val recommendedMovieImageUrl: String,
)