package com.red_velvet.flix.ui.login

import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.usecase.LoginUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel<LoginUiState>() {


    private val _loginUIState = MutableStateFlow(LoginUiState())
    override val state = _state

    fun onUserNameInputChange(text: CharSequence) {
        _loginUIState.value = _loginUIState.value.copy(userName = text.toString())
    }

    fun onPasswordInputChange(text: CharSequence) {
        _loginUIState.value = _loginUIState.value.copy(password = text.toString())
    }

    fun onClickLogin() {
        login()
    }

    private fun login() {
        viewModelScope.launch {
            try {
                _loginUIState.value = _loginUIState.value.copy(isLoading = true)
                loginUseCase(_loginUIState.value.userName, _loginUIState.value.password)

                _loginUIState.value = _loginUIState.value.copy(
                    isLoading = false,
                    error = ""
                )
            } catch (e: Exception) {
                _loginUIState.value = _loginUIState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error"
                )
            }
        }
    }

    override val _state: MutableStateFlow<LoginUiState>
        get() = TODO("Not yet implemented")
}