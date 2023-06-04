package com.red_velvet.flix.ui.home

import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.usecase.GetNowPlayingMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetPopularMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetTopRatedMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetUpcomingMoviesUsecase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.home.adapter.MovieInteractionListener
import com.red_velvet.flix.ui.home.adapter.toUiState
import com.red_velvet.flix.ui.home.homeUiState.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUsecase: GetPopularMoviesUsecase,
    private val getNowPlayingMoviesUsecase: GetNowPlayingMoviesUsecase,
    private val getUpcomingMoviesUsecase: GetUpcomingMoviesUsecase,
    private val getTopRatedMoviesUsecase: GetTopRatedMoviesUsecase,
) : BaseViewModel(), MovieInteractionListener {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    init {
        getHomeData()
    }

    private fun getHomeData() {
//        _homeUiState.update { it.copy(isLoading = true) }
        getPopularMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getTopRatedMovies()
    }


    private fun getPopularMovies() {
        viewModelScope.launch {
            try {
                getPopularMoviesUsecase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.toUiState()
                        _homeUiState.update {
                            it.copy(
                                popularMovies = HomeItem.Popular(items),
                                isLoading = false
                            )
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }
    }

    private fun getNowPlayingMovies() {
        viewModelScope.launch {
            try {
                getNowPlayingMoviesUsecase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.toUiState()
                        _homeUiState.update {
                            it.copy(
                                nowPlayingMovies = HomeItem.NowPlaying(items),
                                isLoading = false
                            )
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            try {
                getUpcomingMoviesUsecase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.toUiState()
                        _homeUiState.update {
                            it.copy(
                                upcomingMovies = HomeItem.Upcoming(items),
                                isLoading = false
                            )
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            try {
                getTopRatedMoviesUsecase().collect { list ->
                    if (list.isNotEmpty()) {
                        val items = list.toUiState()
                        _homeUiState.update {
                            it.copy(
                                topRatedMovies = HomeItem.TopRated(items),
                                isLoading = false
                            )
                        }
                    }
                }
            } catch (th: Throwable) {
                onError(th.message.toString())
            }
        }
    }


    private fun onError(message: String) {
        val errors = _homeUiState.value.error.toMutableList()
        errors.add(message)
        _homeUiState.update { it.copy(error = errors, isLoading = false) }
    }


    override fun onClickMovie(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllMovie(homeItemsType: HomeItemsType) {
        TODO("Not yet implemented")
    }
}