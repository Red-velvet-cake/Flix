package com.red_velvet.flix.ui.movieDetails

data class MovieUiState(
    val isFavorite: Boolean,
    val isSaved: Boolean,
    val goBack: Boolean,
    val watchTrailer: Boolean,
    val movieName: String,
    val imageUrl: String,
    val movieCategories: List<String>,
    val movieTime: String,
    val movieLanguage: String,
    val movieRating: Double,
    val rateTheMovie: Boolean,
    val description: String,
    val seeAllCast: Boolean,
    val topCast: List<TopCast>,
    val status: String,
    val releasedDate: String,
    val productionCountries: String,
    val keyWords: List<String>,
    val seeAllSimilarMovies: Boolean,
    val similarMovies: List<SimilarMovie>,
    val seeAllImagesBelongToMovie: Boolean,
    val imageBelongToMovie: List<String>,
    val latest: String,
    val seeAllReviews: Boolean,
    val review: List<MovieReview>,
    val seeAllRecommendations: Boolean,
    val movieRecommendations: List<MovieRecommendations>,
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