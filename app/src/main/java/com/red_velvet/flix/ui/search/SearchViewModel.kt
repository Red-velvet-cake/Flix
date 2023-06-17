package com.red_velvet.flix.ui.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.entity.PersonEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.usecase.SearchMovieUseCase
import com.red_velvet.flix.domain.usecase.SearchPersonUseCase
import com.red_velvet.flix.domain.usecase.SearchSeriesUseCase
import com.red_velvet.flix.domain.usecase.SearchUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.search.adapter.MediaSearchInteractionListener
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaSearchUiState
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaUiState
import com.red_velvet.flix.ui.search.mediaSearchUiState.SearchTypes
import com.red_velvet.flix.ui.search.mediaSearchUiState.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("UNUSED_EXPRESSION")
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val multiSearchUseCase: SearchUseCase,
    private val searchMovieUseCase: SearchMovieUseCase,
    private val searchSeriesUseCase: SearchSeriesUseCase,
    private val searchPersonUseCase: SearchPersonUseCase
) : BaseViewModel<MediaSearchUiState>(), MediaSearchInteractionListener {


    override val _state = MutableStateFlow(MediaSearchUiState())
    override val state: StateFlow<MediaSearchUiState> = _state.asStateFlow()

    private val _searchUIEvent = MutableStateFlow<SearchUIEvent?>(null)
    val searchUIEvent = _searchUIEvent.asStateFlow()


    override fun onClickMediaResult(media: MediaUiState) {
        _searchUIEvent.update { SearchUIEvent.ClickMediaEvent(media) }
    }

    override fun onClickPersonResult(personId: Int, name: String) {
        _searchUIEvent.update { SearchUIEvent.ClickPersonEvent(personId) }
    }


    fun onChangeSearchTextFiled(searchInput: CharSequence) {
        _state.update { it.copy(searchInput = searchInput.toString(), isLoading = true) }
        viewModelScope.launch {
            when (_state.value.searchTypes) {
                SearchTypes.MOVIE -> onSearchForMovie()
                SearchTypes.PERSON -> onSearchForPerson()
                SearchTypes.SERIES -> onSearchForTvShow()
                SearchTypes.ALL -> onSearchForAll()
            }
        }
        ::onError
    }


    fun onSearchForAll() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { multiSearchUseCase(state.value.searchInput) },
            ::onSearchForAllSuccess,
            ::onError
        )


    }

    private fun onSearchForAllSuccess(media: List<MovieEntity>) {
        val mediaUiState = media.map(MovieEntity::toUiState)
        _state.update {
            it.copy(
                searchTypes = SearchTypes.ALL,
                isLoading = false,
                searchResult = mediaUiState,
                error = null
            )

        }
    }


    fun onSearchForMovie() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { searchMovieUseCase(state.value.searchInput) },
            ::onSearchForMovieSuccess,
            ::onError
        )
    }

    private fun onSearchForMovieSuccess(movies: List<MovieEntity>) {
        val moviesUiState = movies.map(MovieEntity::toUiState)
        _state.update {
            it.copy(
                searchTypes = SearchTypes.MOVIE,
                isLoading = false,
                searchResult = moviesUiState,
                error = null
            )
        }
    }

    fun onSearchForPerson() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { searchPersonUseCase(state.value.searchInput) },
            ::onSearchForPersonSuccess,
            ::onError
        )

    }

    private fun onSearchForPersonSuccess(person: List<PersonEntity>) {
        val personUiState = person.map(PersonEntity::toUiState)
        _state.update {
            it.copy(
                searchTypes = SearchTypes.PERSON,
                isLoading = false,
                searchResult = personUiState,
                error = null
            )
        }
    }

    fun onSearchForTvShow() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { searchSeriesUseCase(state.value.searchInput) },
            ::onSearchForSeriesSuccess,
            ::onError
        )

    }

    private fun onSearchForSeriesSuccess(series: List<SeriesEntity>) {
        val seriesUiState = series.map(SeriesEntity::toUiState)
        _state.update {
            it.copy(
                searchTypes = SearchTypes.SERIES,
                isLoading = false,
                searchResult = seriesUiState,
                error = null
            )
        }
        Log.i("mustafa", _state.value.searchResult.toString())
    }

    private fun onError(error: ErrorUiState) {
        _state.update { it.copy(error = error, isLoading = false) }
    }


}


