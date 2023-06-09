package com.red_velvet.flix.ui.login

import android.util.Log
import com.red_velvet.flix.domain.usecase.RequestTokenUseCase
import com.red_velvet.flix.domain.usecase.SessionCreationUseCase
import com.red_velvet.flix.domain.usecase.SessionStorageUseCase
import com.red_velvet.flix.domain.usecase.StoreRequestTokenUseCase
import com.red_velvet.flix.domain.usecase.login.LoginUseCase
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
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val passwordValidateUseCase: PasswordValidateUseCase,
    private val userNameValidateUseCase: UserNameValidateUseCase,
    private val requestTokenUseCase: RequestTokenUseCase,
    private val sessionCreationUseCase: SessionCreationUseCase,
    private val storeRequestTokenUseCase: StoreRequestTokenUseCase,
    private val sessionStorageUseCase: SessionStorageUseCase
) : BaseViewModel<LoginUiState>() {

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
        val userName = _state.value.userName
        val password = _state.value.password
        if (validateForm(userName, password)) {
            _state.value = _state.value.copy(isLoading = true)
            tryToExecute(
                call = { performLogin(userName, password) },
                onSuccess = { onLoginSuccessfully() },
                onError = { error -> onLoginError(error) }
            )
        }
    }

    private suspend fun performLogin(userName: String, password: String) {
        val requestTokenUseCase = requestTokenUseCase()
        storeRequestTokenUseCase(requestTokenUseCase.requestToken)
        val loginResult = loginUseCase(userName, password, requestTokenUseCase.requestToken)
        val sessionId = sessionCreationUseCase(loginResult.requestToken)
        sessionStorageUseCase(sessionId)
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

    private fun onLoginError(errorUiState: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = errorUiState
            )
        }
    }

    private fun onLoginSuccessfully() {
        Log.d("onLoginSuccessfully ", ":")
        _state.update { it.copy(isLoading = false) }
        _loginEvent.value = Event(LoginUIEvent.LoginEvent)
        resetForm()
    }

    private fun resetForm() {
        _state.update { it.copy(userName = "", password = "") }
    }
}