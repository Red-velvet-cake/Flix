package com.red_velvet.flix.ui.movieDetails

import com.red_velvet.flix.domain.entity.KeywordEntity
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.movie.MovieCastEntity
import com.red_velvet.flix.domain.entity.movie.MovieDetailsEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.movie.MovieImageEntity
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
    val movieCategories: List<MovieKeywords> = emptyList(),
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
    val keyWords: List<MovieKeywords> = emptyList(),
    val seeAllSimilarMovies: Boolean = false,
    val similarMovies: List<MovieList> = emptyList(),
    val seeAllImagesBelongToMovie: Boolean = false,
    val imageBelongToMovie: List<ImageBelongToMovie> = emptyList(),
    val latest: String = "",
    val seeAllReviews: Boolean = false,
    val review: List<MovieReview> = emptyList(),
    val seeAllRecommendations: Boolean = false,
    val movieRecommendations: List<MovieList> = emptyList(),
) : BaseUiState
{
    data class MovieList(
        val id:Int,
        val movieImageUrl: String,
        val movieName: String,
    )
    data class ImageBelongToMovie(
        val imageBelongToMovieUrl:String
    )

    data class MovieReview(
        val rating: Int,
        val movieReviewer: String,
        val movieReview: String,
    )
    data class TopCast(
        val imageUrl: String,
        val name: String
    )
    data class MovieKeywords(
        val keyword:String
    )
}

fun ReviewEntity.toReviewUiState():MovieUiState.MovieReview
{
    return MovieUiState.MovieReview(rating = rating , movieReview = content , movieReviewer = author.name)
}
fun List<ReviewEntity>.toReviewUiState():List<MovieUiState.MovieReview>
{
    return map { it.toReviewUiState() }
}
fun List<MovieEntity>.toListOfMovies(): List<MovieUiState.MovieList> {
    return map { it.toMoviesUiState() }
}

fun MovieEntity.toMoviesUiState(): MovieUiState.MovieList {
    return MovieUiState.MovieList(movieName = title, movieImageUrl = imageUrl, id = id)
}
fun MovieImageEntity.toImagesUiState():MovieUiState.ImageBelongToMovie{
    return MovieUiState.ImageBelongToMovie(imageBelongToMovieUrl = filePath)
}
fun List<MovieImageEntity>.toImagesUiState():List<MovieUiState.ImageBelongToMovie> {
    return map { it.toImagesUiState() }
}
fun MovieCastEntity.toTopCast():MovieUiState.TopCast{
    return MovieUiState.TopCast(name = name, imageUrl = imageUrl)
}
fun List<MovieCastEntity>.toTopCast():List<MovieUiState.TopCast>{
    return map { it.toTopCast() }
}
fun String.toMovieKeyword():MovieUiState.MovieKeywords{
    return MovieUiState.MovieKeywords(keyword = this)
}
fun List<String>.toMovieKeyword():List<MovieUiState.MovieKeywords>{
    return map { it.toMovieKeyword()}
}
