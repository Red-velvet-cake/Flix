package com.red_velvet.flix.ui.movieDetails

import androidx.lifecycle.ViewModel
import com.red_velvet.flix.domain.model.movie.MovieDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val movieUiState: MovieUiState,private val movieDetails: MovieDetails): ViewModel() {
    private val _uiState: MutableStateFlow<MovieUiState> = MutableStateFlow(movieUiState)
    val uiState: StateFlow<MovieUiState> = _uiState
    fun onFetchData() {
        _uiState.update {
            it.copy(
                isLoading = false,
            movieName = movieDetails.title,
            imageUrl = movieDetails.imageUrl,
            description = movieDetails.overview,
            )
        }
    }
}