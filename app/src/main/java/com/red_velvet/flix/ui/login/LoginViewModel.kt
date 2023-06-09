package com.red_velvet.flix.ui.login

import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.usecase.LoginUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel<LoginUiState>() {
    override val _state: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    override val state: StateFlow<LoginUiState> = _state.asStateFlow()

    fun onUserNameInputChange(text: CharSequence) {
        _state.value = _state.value.copy(userName = text.toString())
    }

    fun onPasswordInputChange(text: CharSequence) {
        _state.value = _state.value.copy(password = text.toString())
    }

    fun onClickLogin() {
        login()
    }

    private fun login() {
        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(isLoading = true)
                loginUseCase(_state.value.userName, _state.value.password)

                _state.value = _state.value.copy(
                    isLoading = false,
                    error = ""
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error"
                )
            }
        }
    }
}