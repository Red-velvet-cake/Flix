package com.red_velvet.flix.ui.base

sealed class ErrorUiState {
    object NoInternet : ErrorUiState()

    object Unauthorized : ErrorUiState()

    object ServerError : ErrorUiState()

    object Timeout : ErrorUiState()

    object UnknownError : ErrorUiState()
}