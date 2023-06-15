package com.red_velvet.flix.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.utils.FlixException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel<T : BaseUiState> : ViewModel() {
    protected abstract val _state: MutableStateFlow<T>
    abstract val state: StateFlow<T>

    fun <T> tryToExecute(
        call: suspend () -> Flow<T>,
        onSuccess: (T) -> Unit,
        onError: (ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = call()
                launch(Dispatchers.Main) {
                    result.collect { data ->
                        onSuccess(data)
                    }
                }
            } catch (e: FlixException.Unauthorized) {
                onError(ErrorUiState.UnAuthorized)
            } catch (e: FlixException.ServerError) {
                onError(ErrorUiState.ServerError)
            } catch (e: FlixException.InvalidUsernameOrPassword) {
                onError(ErrorUiState.InvalidUsernameOrPassword)
            } catch (e: FlixException.EmailNotVerified) {
                onError(ErrorUiState.EmailNotVerified)
            } catch (e: FlixException.NoInternet) {
                onError(ErrorUiState.NoInternet)
            } catch (e: FlixException.TimeOut) {
                onError(ErrorUiState.TimeOut)
            } catch (e: Exception) {
                onError(ErrorUiState.Unknown)
            }
        }
    }
}

