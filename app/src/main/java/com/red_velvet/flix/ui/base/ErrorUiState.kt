package com.red_velvet.flix.ui.base

sealed class ErrorUiState {
    abstract val message: String
    object UnAuthorized : ErrorUiState() {
        override val message = "Unauthorized"
    }
    object ServerError : ErrorUiState() {
        override val message = "Server error"
    }
    object InvalidUsernameOrPassword : ErrorUiState() {
        override val message = "Invalid username or password"
    }
    object EmailNotVerified : ErrorUiState() {
        override val message = "Email not verified"
    }
    object NoInternet : ErrorUiState() {
        override val message = "No internet"
    }
    object TimeOut : ErrorUiState() {
        override val message = "Timeout"
    }
    object Unknown : ErrorUiState() {
        override val message = "Unknown error"
    }
    fun isUnAuthorized() = this is UnAuthorized
    fun isServerError() = this is ServerError
    fun isInvalidUsernameOrPassword() = this is InvalidUsernameOrPassword
    fun isEmailNotVerified() = this is EmailNotVerified
    fun isNoInternet() = this is NoInternet
    fun isTimeOut() = this is TimeOut
    fun isUnknown() = this is Unknown
}