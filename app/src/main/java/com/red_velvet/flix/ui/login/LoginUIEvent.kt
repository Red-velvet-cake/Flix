package com.red_velvet.flix.ui.login

sealed class LoginUIEvent {
    object LoginEvent: LoginUIEvent()
    object GuestEvent: LoginUIEvent()
}