package com.red_velvet.flix.ui.movieDetails

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.entity.movie.MovieDetailsEntity
import com.red_velvet.flix.domain.usecase.GetMovieDetailsUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) :
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
        _state.update { it.copy(isLoading = false) }
    }

    private fun onError(error: ErrorUiState) {
        Log.i("jalalCheff",error.toString())
    }

    companion object {
        const val MOVIE_ID = 385687
    }
}