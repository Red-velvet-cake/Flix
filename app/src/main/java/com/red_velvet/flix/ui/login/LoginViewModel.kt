package com.red_velvet.flix.ui.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.usecase.login.LoginUseCase
import com.red_velvet.flix.domain.usecase.login.PasswordMatchingUseCase
import com.red_velvet.flix.domain.usecase.login.PasswordValidateUseCase
import com.red_velvet.flix.domain.usecase.login.UserNameValidateUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val passwordMatchingUseCase: PasswordMatchingUseCase,
    private val passwordValidateUseCase: PasswordValidateUseCase,
    private val userNameValidateUseCase: UserNameValidateUseCase
): BaseViewModel<LoginUiState>() {

    override val _state: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    override val state: StateFlow<LoginUiState> = _state.asStateFlow()

    private val _loginEvent = MutableStateFlow<Event<LoginUIEvent?>>(Event(null))
    val loginEvent = _loginEvent

    fun onUserNameChanged(userName: CharSequence) {
        val isValidUserName = userNameValidateUseCase(userName.toString())
        _state.value = _state.value.copy(
            userName = userName.toString(),
            userNameHelperText = if (isValidUserName) "" else "Invalid username.",
            isValidForm = isValidUserName && _state.value.password.isNotEmpty()
        )
    }

    fun onPasswordChanged(password: CharSequence) {
        val isValidPassword = passwordValidateUseCase(password.toString())
        _state.value = _state.value.copy(
            password = password.toString(),
            passwordHelperText = if (isValidPassword) "" else "Invalid password. Password should have at least 6 characters.",
            isValidForm = isValidPassword && _state.value.userName.isNotEmpty()
        )
    }

    fun onLoginClicked() {
        viewModelScope.launch {
            Log.d("onLoginClicked ", ": ${_state.value.isValidForm}")
            if (_state.value.isValidForm) {
                _state.value = _state.value.copy(isLoading = true)
                tryToExecute(
                    call = { loginUseCase(_state.value.userName, _state.value.password) },
                    onSuccess = { onLoginSuccessfully() },
                    onError = { error -> onLoginError(error) }
                )
            } else {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = "Please enter a valid username and password."
                )
            }
        }
    }
    private fun onLoginError(errorUiState: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = errorUiState.message,
                passwordHelperText = errorUiState.message
            )
        }
    }

    private fun onLoginSuccessfully() {
        _state.update { it.copy(isLoading = false) }
        _loginEvent.value = Event(LoginUIEvent.LoginEvent)
        resetForm()
    }

    private fun resetForm() {
        _state.update { it.copy(userName = "", password = "") }
    }
}