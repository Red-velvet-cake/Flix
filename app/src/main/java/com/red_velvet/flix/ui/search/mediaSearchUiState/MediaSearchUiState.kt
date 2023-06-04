package com.red_velvet.flix.ui.search.mediaSearchUiState

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class MediaSearchUiState(
    val searchInput: String = "",
    val searchTypes: SearchTypes = SearchTypes.ALL,
    val searchResult: List<MediaUiState> = emptyList(),
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val error: List<Error> = emptyList()
)