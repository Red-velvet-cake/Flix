package com.red_velvet.flix.domain.utils

sealed class FlixException : Exception() {

    object Unauthorized : FlixException()

    object InvalidAPIKey : FlixException()

    object ServerError : FlixException()

    object InvalidUsernameOrPassword : FlixException()

    object EmailNotVerified : FlixException()

    object InvalidRequestToken : FlixException()

    object NoInternet : FlixException()

    object TimeOut : FlixException()

    object Unknown : FlixException()
}