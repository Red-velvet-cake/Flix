package com.red_velvet.flix.ui.base

sealed class ErrorUiState {

    object UnAuthorized : ErrorUiState()

    object ServerError : ErrorUiState()

    object InvalidUsernameOrPassword : ErrorUiState()

    object EmailNotVerified : ErrorUiState()

    object NoInternet : ErrorUiState()

    object TimeOut : ErrorUiState()

    object Unknown : ErrorUiState()

    fun isUnAuthorized() = this is UnAuthorized

    fun isServerError() = this is ServerError

    fun isInvalidUsernameOrPassword() = this is InvalidUsernameOrPassword

    fun isEmailNotVerified() = this is EmailNotVerified

    fun isNoInternet() = this is NoInternet

    fun isTimeOut() = this is TimeOut

    fun isUnknown() = this is Unknown

}