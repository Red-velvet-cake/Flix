package com.red_velvet.flix.ui.movieDetails

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.movie.MovieDetailsEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.usecase.GetMovieDetailsUseCase
import com.red_velvet.flix.domain.usecase.GetMovieReviewsUseCase
import com.red_velvet.flix.domain.usecase.GetMoviesRecommendationsUseCase
import com.red_velvet.flix.domain.usecase.GetSimilarMoviesUseCase
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
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
) : BaseViewModel<MovieUiState>(), BaseInteractionListener {
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
        Log.i("jalalCheff", similarMovies.toString())
    }
    private fun onSuccessReviewMovies(reviews: List<ReviewEntity>)
    {
        _state.update { it.copy(review = reviews.toUiState()) }
    }

    private fun onError(error: ErrorUiState) {
        Log.i("jalalCheff", error.toString())
    }

    companion object {
        const val MOVIE_ID = 603692
    }
}