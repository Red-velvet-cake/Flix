package com.red_velvet.flix.ui.search

import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.search.adapter.MediaSearchInteractionListener
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaSearchUiState
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaUiState
import com.red_velvet.flix.ui.search.mediaSearchUiState.SearchMediaUiStateMapper
import com.red_velvet.flix.ui.search.mediaSearchUiState.SearchTypes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMediaUiStateMapper: SearchMediaUiStateMapper,

    ) : BaseViewModel(), MediaSearchInteractionListener {

    private val _uiState = MutableStateFlow(MediaSearchUiState())
    val uiState = _uiState.asStateFlow()


    override fun onClickMediaResult(media: MediaUiState) {
        TODO("Not yet implemented")
    }

//    fun onSearchInputChange(searchTerm: CharSequence) {
//        _uiState.update { it.copy(searchInput = searchTerm.toString(), isLoading = true) }
//        viewModelScope.launch {
//            when (_uiState.value.searchTypes) {
//                SearchTypes.Movie -> onSearchForMovie()
//                SearchTypes.Tv -> onSearchForTV()
//                SearchTypes.Person -> onSearchForPerson()
//                SearchTypes.ALL -> onSearchForAll()
//
//            }
//        }
//    }
}