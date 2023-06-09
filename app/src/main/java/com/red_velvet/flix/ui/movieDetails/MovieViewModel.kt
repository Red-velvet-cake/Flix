package com.red_velvet.flix.ui.movieDetails

import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.entity.movie.MovieDetailsEntity
import com.red_velvet.flix.domain.usecase.GetMovieDetailsUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewMode @Inject constructor(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) :
    BaseViewModel<MovieUiState>() {
    override val _state: MutableStateFlow<MovieUiState> = MutableStateFlow(MovieUiState())
    override val state: StateFlow<MovieUiState> = _state

    init {
        onFetchMovieDetailsData()
    }

    private fun onFetchMovieDetailsData() {
        viewModelScope.launch {
            tryToExecute({ getMovieDetailsUseCase.invoke(MOVIE_ID) }, ::onSuccess, ::onError)
        }
    }

    private fun onSuccess(movieDetails: MovieDetailsEntity) {

    }

    private fun onError(error: ErrorUiState) {

    }

    companion object {
        const val MOVIE_ID = 1
    }
}