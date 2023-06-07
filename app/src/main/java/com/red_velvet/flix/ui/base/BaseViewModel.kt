package com.red_velvet.flix.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T : BaseUiState> : ViewModel() {

    abstract val _state: MutableStateFlow<T>
    abstract val state: StateFlow<T>

    fun <T> tryToExecute(
        callee: suspend () -> Flow<T>,
        collector: suspend (T) -> Unit,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val flow = callee()
                delay(1000)
                flow.collect { data ->
                    collector(data)
                }
            } catch (throwable: Throwable) {
                onError(throwable)
            }
        }
    }


}

