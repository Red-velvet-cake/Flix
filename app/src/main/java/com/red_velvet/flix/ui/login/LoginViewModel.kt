package com.red_velvet.flix.ui.login

import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.usecase.login.guest.CreateGuestSessionLoginUseCase
import com.red_velvet.flix.domain.usecase.login.user.UserLoginUseCase
import com.red_velvet.flix.domain.usecase.login.user.PasswordValidateUseCase
import com.red_velvet.flix.domain.usecase.login.user.UserNameValidateUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userLoginUseCase: UserLoginUseCase,
    private val guestLoginUseCase: CreateGuestSessionLoginUseCase,
    private val passwordValidateUseCase: PasswordValidateUseCase,
    private val userNameValidateUseCase: UserNameValidateUseCase,
) : BaseViewModel<LoginUiState>() {

    override val _state: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    override val state: StateFlow<LoginUiState> = _state.asStateFlow()

    private val _loginEvent = MutableSharedFlow<LoginUIEvent>()
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
        val userName = _state.value.userName
        val password = _state.value.password
        if (validateForm(userName, password)) {
            startLoading()
            tryToExecute(
                call = { userLoginUseCase(userName, password) },
                onSuccess = { onLoginEvent(LoginUIEvent.LoginEvent) },
                onError = { error -> onLoginError(error) }
            )
        }
    }

    fun onGuestClicked() {
        startLoading()
        tryToExecute(
            call = { guestLoginUseCase() },
            onSuccess = { onLoginEvent(LoginUIEvent.GuestEvent) },
            onError = { error -> onLoginError(error) }
        )
    }

    private fun onLoginError(errorUiState: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = errorUiState
            )
        }
    }

    private fun onLoginEvent(loginUIEvent: LoginUIEvent) {
        stopLoading()
        viewModelScope.launch {
            loginEvent.emit(loginUIEvent)
        }
        resetForm()
    }

    private fun validateForm(userName: String, password: String): Boolean {
        val isValidUserName = userNameValidateUseCase(userName)
        val isValidPassword = passwordValidateUseCase(password)

        _state.value = _state.value.copy(
            userNameHelperText = if (isValidUserName) "" else "Invalid username.",
            passwordHelperText = if (isValidPassword) "" else "Password should have at least 6 characters.",
            isValidForm = isValidUserName && isValidPassword
        )

        return _state.value.isValidForm
    }

    private fun resetForm() {
        _state.update { it.copy(userName = "", password = "") }
    }

    private fun startLoading() {
        _state.update { it.copy(isLoading = true) }
    }

    private fun stopLoading() {
        _state.update { it.copy(isLoading = false) }
    }
}