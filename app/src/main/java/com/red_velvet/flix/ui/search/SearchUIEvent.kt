package com.red_velvet.flix.ui.search

import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaUiState

sealed interface SearchUIEvent {

    data class ClickMediaEvent(val mediaUIState: MediaUiState) : SearchUIEvent
    data class ClickPersonEvent(val personID: Int) : SearchUIEvent
    object ClickBackEvent : SearchUIEvent

}