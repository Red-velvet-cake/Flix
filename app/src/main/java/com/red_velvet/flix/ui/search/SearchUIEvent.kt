package com.red_velvet.flix.ui.search

import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaUiState

sealed interface SearchUIEvent {

    object ClickRetryEvent : SearchUIEvent

    data class ClickMediaEvent(val mediaUIState: MediaUiState) : SearchUIEvent

}