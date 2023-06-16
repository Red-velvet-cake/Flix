package com.red_velvet.flix.ui.moviesbykeyword

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.usecase.GetMoviesByKeywordUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.moviesbykeyword.uiState.KeywordUiState
import com.red_velvet.flix.ui.moviesbykeyword.uiState.toMovieUiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KeywordViewModel @Inject constructor(
    private val getMoviesByKeywordUseCase: GetMoviesByKeywordUseCase
) : BaseViewModel<KeywordUiState>(),MovieInteractionListener {

    override val _state = MutableStateFlow(KeywordUiState())
    override val state: StateFlow<KeywordUiState> = _state

    private val _uiEvent = MutableSharedFlow<UIEventMoviesByKeyword>()
    val uiEvent = _uiEvent

    init {
        getMoviesByKeyword(1700)
    }

    private fun getMoviesByKeyword(keywordId: Int) {
        tryToExecute(
            call = { getMoviesByKeywordUseCase(keywordId) },
            onSuccess = { onMoviesReceived(it) },
            onError = { onMoviesError(it) }
        )
    }

    private fun onMoviesReceived(movies: List<MovieEntity>) {
        val movieUiStates = movies.map { it.toMovieUiStates() }
        _state.update { it.copy(movieList = movieUiStates) }
        Log.d("onMoviesReceived", "${movieUiStates.size} ")
    }

    private fun onMoviesError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState) }
    }

//    fun onMovieClicked(movie: MovieUiState) {
//        viewModelScope.launch {
//            _uiEvent.emit(UIEventMoviesByKeyword.NavigateToMovieDetail(movie.id ?: 0))
//        }
//    }

    override fun onMovieClick(id: Int) {
        viewModelScope.launch {
            _uiEvent.emit(UIEventMoviesByKeyword.NavigateToMovieDetail(id))
        }
    }
}