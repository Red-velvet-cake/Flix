package com.red_velvet.flix.ui.movieDetails

interface MovieDetailsInteractionListener {
    fun onBackButtonClick()
    fun onSaveButtonClick()
    fun onFavouriteButtonClick()
    fun onRateButtonClick()
    fun onSeeAllTopCastClick()
    fun onSimilarMovieItemClick(movieId: Int)
    fun onSeeAllSimilarMovieClick()
    fun onSeeAllImagesBelongToMovieClick()
    fun onSeeAllReviewsClick()
    fun onReviewItemClick(movieId: Int)
    fun onSeeAllRecommendationMovieClick()
    fun onRecommendationMovieItemClick(movieId: Int)
}