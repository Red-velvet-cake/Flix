package com.red_velvet.flix.ui.login

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.usecase.login.LoginUseCase
import com.red_velvet.flix.domain.usecase.login.PasswordMatchingUseCase
import com.red_velvet.flix.domain.usecase.login.PasswordValidateUseCase
import com.red_velvet.flix.domain.usecase.login.UserNameValidateUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
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
): BaseViewModel() {

    private val _loginUIState = MutableStateFlow(LoginUiState())
    val loginUIState: StateFlow<LoginUiState> = _loginUIState

    private val _loginEvent = MutableStateFlow<Event<LoginUIEvent?>>(Event(null))
    val loginEvent = _loginEvent

    fun onUserNameChanged(userName: CharSequence) {
        val isValidUserName = userNameValidateUseCase(userName.toString())
        _loginUIState.value = _loginUIState.value.copy(
            userName = userName.toString(),
            userNameHelperText = if (isValidUserName) "" else "Invalid username.",
            isValidForm = isValidUserName && _loginUIState.value.password.isNotEmpty()
        )
    }

    fun onPasswordChanged(password: CharSequence) {
        val isValidPassword = passwordValidateUseCase(password.toString())
        _loginUIState.value = _loginUIState.value.copy(
            password = password.toString(),
            passwordHelperText = if (isValidPassword) "" else "Invalid password. Password should have at least 6 characters.",
            isValidForm = isValidPassword && _loginUIState.value.userName.isNotEmpty()
        )
    }

    fun onLoginClicked() {
        viewModelScope.launch {
            Log.d("onLoginClicked ", ": ${_loginUIState.value.isValidForm}")
            if (_loginUIState.value.isValidForm) {
                _loginUIState.value = _loginUIState.value.copy(isLoading = true)
                try {
                    loginUseCase(_loginUIState.value.userName, _loginUIState.value.password)
                    onLoginSuccessfully()
                } catch (e: Exception) {
                    onLoginError(e.localizedMessage)
                }
            } else {
                _loginUIState.value = _loginUIState.value.copy(
                    isLoading = false,
                    error = "Please enter a valid username and password."
                )
            }
        }
    }

    private fun onLoginSuccessfully() {
        _loginUIState.update { it.copy(isLoading = false) }
        _loginEvent.value = Event(LoginUIEvent.LoginEvent)
        resetForm()
    }

    private fun resetForm() {
        _loginUIState.update { it.copy(userName = "", password = "") }
    }

    private fun onLoginError(message: String) {
        _loginUIState.update {
            it.copy(
                isLoading = false,
                error = message,
                passwordHelperText = message
            )
        }
    }
}