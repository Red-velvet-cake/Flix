package com.red_velvet.flix.ui.login

data class LoginUiState(
    val userName :String = "",
    val password :String = "",
    val isLoading:Boolean = false,
    val error:String = ""
)