package com.red_velvet.flix.ui.base

sealed class ErrorUiState {
    object UnAuthorized : ErrorUiState()
    object ServerError : ErrorUiState()
    object InvalidUsernameOrPassword : ErrorUiState()
    object EmailNotVerified : ErrorUiState()
    object NoInternet : ErrorUiState()
    object TimeOut : ErrorUiState()
    object Unknown : ErrorUiState()
}