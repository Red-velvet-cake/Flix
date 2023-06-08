package com.red_velvet.flix.ui.base

sealed class BaseErrorUiState {
    object UnAuthorized : BaseErrorUiState()
    object InvalidApiKey : BaseErrorUiState()
    object ServerError : BaseErrorUiState()
    object InvalidUsernameOrPassword : BaseErrorUiState()
    object EmailNotVerified : BaseErrorUiState()
    object InvalidRequestToken : BaseErrorUiState()
    object NoInternet : BaseErrorUiState()
    object TimeOut : BaseErrorUiState()
    object Unknown : BaseErrorUiState()
}
