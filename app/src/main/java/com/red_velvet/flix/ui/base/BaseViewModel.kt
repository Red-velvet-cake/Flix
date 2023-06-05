package com.red_velvet.flix.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.model.movie.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T : BaseUiState> : ViewModel() {

    protected val _state = MutableStateFlow<T?>(null)
    val state: StateFlow<T?> = _state.asStateFlow()

    protected fun handleMoviesSuccess(
        list: List<Movie>, stateModifier: (T, List<Movie>) -> T
    ) {
        if (list.isNotEmpty()) {
            _state.value?.let { currentState ->
                _state.value = stateModifier(currentState, list)
            }
        }
    }

    fun <T> tryToExecute(
        callee: suspend () -> Flow<T>,
        collector: suspend (T) -> Unit,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val flow = callee()
                flow.collect { data ->
                    collector(data)
                }
            } catch (throwable: Throwable) {
                onError(throwable)
            }
        }
    }


}

