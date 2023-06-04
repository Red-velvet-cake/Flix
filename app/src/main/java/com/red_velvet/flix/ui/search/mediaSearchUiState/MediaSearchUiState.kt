package com.red_velvet.flix.ui.search.mediaSearchUiState


data class MediaSearchUiState(
    val searchInput: String = "",
    val searchTypes: List<SearchTypes> = emptyList(),
    val searchResult: List<MediaUiState> = emptyList(),
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val error: List<Error> = emptyList()
)