package com.red_velvet.flix.ui.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.usecase.SearchUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.search.adapter.MediaSearchInteractionListener
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaSearchUiState
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaUiState
import com.red_velvet.flix.ui.search.mediaSearchUiState.SearchTypes
import com.red_velvet.flix.ui.search.mediaSearchUiState.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("UNUSED_EXPRESSION")
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUsecase: SearchUseCase,
) : BaseViewModel<MediaSearchUiState>(), MediaSearchInteractionListener {

    

    override val _state = MutableStateFlow(MediaSearchUiState())
    override val state: StateFlow<MediaSearchUiState> = _state.asStateFlow()


//    private val _searchUIEvent = MutableStateFlow<Event<SearchUIEvent?>>(EventLog.Event(null))
//    val searchUIEvent = _searchUIEvent.asStateFlow()

    override fun onClickMediaResult(media: MediaUiState) {
        TODO("Not yet implemented")
    }


    @OptIn(FlowPreview::class)
    fun onChangeSearchTextFiled(searchInput: CharSequence) {
        _state.apply {
            update { it.copy(searchInput = searchInput.toString(), isLoading = true) }
            debounce(1000)
        }
        viewModelScope.launch {
            when (_state.value.searchTypes) {
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
            _state.update {
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
            _state.update {
                it.copy(
                    searchTypes = SearchTypes.MOVIE,
                    isLoading = false,
                    searchResult = searchUsecase(it.searchInput).map { movie ->
                        movie.toUiState()

                    }
                )
            }
            Log.i("mustafa", _state.value.searchResult.toString() )
        }
        ::onError
    }

    fun onSearchForPerson() {
        viewModelScope.launch {
            _state.update {
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
            _state.update {
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
        _state.update { it.copy(error = emptyList(), isLoading = false) }
    }

   

}


