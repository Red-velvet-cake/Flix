package com.red_velvet.flix.ui.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.usecase.SearchUsecase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.search.adapter.MediaSearchInteractionListener
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaSearchUiState
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaUiState
import com.red_velvet.flix.ui.search.mediaSearchUiState.SearchTypes
import com.red_velvet.flix.ui.search.mediaSearchUiState.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("UNUSED_EXPRESSION")
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUsecase: SearchUsecase,
) : BaseViewModel(), MediaSearchInteractionListener {

    private val _uiState = MutableStateFlow(MediaSearchUiState())
    val uiState = _uiState.asStateFlow()

//    private val _searchUIEvent = MutableStateFlow<Event<SearchUIEvent?>>(EventLog.Event(null))
//    val searchUIEvent = _searchUIEvent.asStateFlow()

    override fun onClickMediaResult(media: MediaUiState) {
        TODO("Not yet implemented")
    }


    @OptIn(FlowPreview::class)
    fun onChangeSearchTextFiled(searchInput: CharSequence) {
        _uiState.apply {
            update { it.copy(searchInput = searchInput.toString(), isLoading = true) }
            debounce(1000)
        }
        viewModelScope.launch {
            when (_uiState.value.searchTypes) {
                SearchTypes.MOVIE -> onSearchForMovie()
                SearchTypes.PERSON -> onSearchForPerson()
                SearchTypes.TV -> onSearchForTvShow()
                SearchTypes.ALL -> onSearchForAll()
            }
        }
        ::onError
    }

    fun onSearchForAll() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    searchTypes = SearchTypes.ALL,
                    isLoading = false,
                    searchResult = searchUsecase(it.searchInput).map { all ->
                        all.toUiState()
                    }
                )
            }
        }
         ::onError
    }


    fun onSearchForMovie() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    searchTypes = SearchTypes.MOVIE,
                    isLoading = false,
                    searchResult = searchUsecase(it.searchInput).map { movie ->
                        movie.toUiState()

                    }
                )
            }
            Log.i("mustafa", _uiState.value.searchResult.toString() )
        }
        ::onError
    }

    fun onSearchForPerson() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    searchTypes = SearchTypes.PERSON,
                    isLoading = false,
                    searchResult = searchUsecase(it.searchInput).map { person ->
                        person.toUiState()
                    }
                )
            }
        }
        ::onError
    }

    fun onSearchForTvShow() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    searchTypes = SearchTypes.TV,
                    isLoading = false,
                    searchResult = searchUsecase(it.searchInput).map { tv ->
                        tv.toUiState()
                    }
                )
            }
        }
        ::onError
    }

    private fun onError() {
        _uiState.update { it.copy(error = emptyList(), isLoading = false) }
    }

}


