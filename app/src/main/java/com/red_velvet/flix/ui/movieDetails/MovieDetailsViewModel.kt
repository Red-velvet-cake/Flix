package com.red_velvet.flix.ui.movieDetails

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.movie.MovieCastEntity
import com.red_velvet.flix.domain.entity.movie.MovieDetailsEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.movie.MovieImageEntity
import com.red_velvet.flix.domain.usecase.GetLatestMovieUseCase
import com.red_velvet.flix.domain.usecase.GetMovieCastUseCase
import com.red_velvet.flix.domain.usecase.GetMovieDetailsUseCase
import com.red_velvet.flix.domain.usecase.GetMovieImagesUseCase
import com.red_velvet.flix.domain.usecase.GetMovieReviewsUseCase
import com.red_velvet.flix.domain.usecase.GetMoviesRecommendationsUseCase
import com.red_velvet.flix.domain.usecase.GetSimilarMoviesUseCase
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getMoviesRecommendationsUseCase: GetMoviesRecommendationsUseCase,
    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase,
    private val getMovieReviewsUseCase: GetMovieReviewsUseCase,
    private val getLatestMovieUseCase: GetLatestMovieUseCase,
    private val getMovieImagesUseCase: GetMovieImagesUseCase,
    private val getMovieCastUseCase: GetMovieCastUseCase
) : BaseViewModel<MovieUiState>(), MovieDetailsInteractionListener, BaseInteractionListener {
    override val _state: MutableStateFlow<MovieUiState> = MutableStateFlow(MovieUiState())
    override val state: StateFlow<MovieUiState> = _state

    init {
        onFetchMovieDetailsData()
    }

    private fun onFetchMovieDetailsData() {
        viewModelScope.launch {
            tryToExecute({ getMovieDetailsUseCase.invoke(MOVIE_ID) }, ::onSuccess, ::onError)
            tryToExecute({ getMoviesRecommendationsUseCase.invoke(MOVIE_ID) }, ::onSuccessRecommendationsMovies, ::onError)
            tryToExecute({ getSimilarMoviesUseCase.invoke(MOVIE_ID) },::onSuccessSimilarMovies, ::onError)
            tryToExecute({getMovieReviewsUseCase.invoke(MOVIE_ID)},::onSuccessReviewMovies,::onError)
            tryToExecute({getLatestMovieUseCase.invoke()},::onSuccessLatestMovie,::onError)
            tryToExecute({getMovieImagesUseCase.invoke(MOVIE_ID)},::onSuccessMovieImages,::onError)
            tryToExecute({getMovieCastUseCase.invoke(MOVIE_ID)},::onSuccessMovieCast,::onError)
        }
    }

    private fun onSuccess(movieDetails: MovieDetailsEntity) {
        _state.update {
            it.copy(
                isLoading = false,
                movieName = movieDetails.title,
                movieTime = movieDetails.runtime,
                description = movieDetails.overview,
                movieLanguage = movieDetails.language,
                imageUrl = movieDetails.imageUrl,
                status = movieDetails.status,
                releasedDate = movieDetails.date,
                productionCountries = movieDetails.productionCountry,
                movieRating = movieDetails.voteAverage.toInt(),
            )
        }
    }

    private fun onSuccessRecommendationsMovies(recommendedMovies: List<MovieEntity>) {
        _state.update { it.copy(movieRecommendations = recommendedMovies.toListOfMovies()) }
    }

    private fun onSuccessSimilarMovies(similarMovies: List<MovieEntity>) {
        _state.update { it.copy(similarMovies = similarMovies.toListOfMovies()) }
    }
    private fun onSuccessReviewMovies(reviews: List<ReviewEntity>)
    {
        _state.update { it.copy(review = reviews.toReviewUiState()) }
    }
    private fun onSuccessLatestMovie(latestMovie:MovieEntity)
    {
        _state.update { it.copy(latest = latestMovie.imageUrl) }

    }
    private fun onSuccessMovieImages(movieImages: List<MovieImageEntity>)
    {
        _state.update { it.copy(imageBelongToMovie = movieImages.toImagesUiState()) }
    }
    private fun onSuccessMovieCast(cast: List<MovieCastEntity>)
    {
        _state.update { it.copy(topCast = cast.toTopCast()) }

    }

    private fun onError(error: ErrorUiState) {
    }

    companion object {
        const val MOVIE_ID = 603692
    }

    override fun onBackButtonClick() {
    }

    override fun onSaveButtonClick() {
    }

    override fun onFavouriteButtonClick() {
    }

    override fun onRateButtonClick() {
    }

    override fun onSeeAllTopCastClick() {
    }

    override fun onSimilarMovieItemClick(movieId: Int) {
    }

    override fun onSeeAllSimilarMovieClick() {
    }

    override fun onSeeAllImagesBelongToMovieClick() {
    }

    override fun onSeeAllReviewsClick() {
    }

    override fun onReviewItemClick(movieId: Int) {
    }

    override fun onSeeAllRecommendationMovieClick() {
    }

    override fun onRecommendationMovieItemClick(movieId: Int) {

    }
}