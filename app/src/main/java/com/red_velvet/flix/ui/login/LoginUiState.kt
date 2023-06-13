package com.red_velvet.flix.ui.login

import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState

data class LoginUiState(
    val userName :String = "",
    val password :String = "",
    val userNameHelperText :String = "",
    val passwordHelperText :String = "",
    val isLoading:Boolean = false,
    val isValidForm : Boolean = false,
    val error:ErrorUiState? = null
) : BaseUiState