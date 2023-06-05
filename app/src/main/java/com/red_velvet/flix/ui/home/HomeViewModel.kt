package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.usecase.GetNowPlayingMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetPopularMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetTopRatedMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetUpcomingMoviesUsecase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.home.adapter.MovieInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUsecase: GetPopularMoviesUsecase,
    private val getNowPlayingMoviesUsecase: GetNowPlayingMoviesUsecase,
    private val getUpcomingMoviesUsecase: GetUpcomingMoviesUsecase,
    private val getTopRatedMoviesUsecase: GetTopRatedMoviesUsecase,
) : BaseViewModel<HomeUiState>(), MovieInteractionListener {

    init {
        getHomeData()
    }

    private fun getHomeData() {
        getPopularMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getTopRatedMovies()
    }

    private fun getNowPlayingMovies() {
        tryToExecute(
            { getNowPlayingMoviesUsecase(1, "US", "en-US") },
            { list -> handleMoviesSuccess(list, ::modifyNowPlayingMoviesState) },
            ::onError,
        )
    }

    private fun modifyNowPlayingMoviesState(state: HomeUiState, movies: List<Movie>): HomeUiState {
        return state.copy(nowPlayingMovies = movies.toUiState())
    }

    private fun getPopularMovies() {
        tryToExecute(
            { getPopularMoviesUsecase(1, "US", "en-US") },
            { list -> handleMoviesSuccess(list, ::modifyPopularMoviesState) },
            ::onError,
        )
    }

    private fun modifyPopularMoviesState(state: HomeUiState, movies: List<Movie>): HomeUiState {
        return state.copy(popularMovies = movies.toUiState())
    }


    private fun getUpcomingMovies() {
        tryToExecute(
            { getUpcomingMoviesUsecase(1, "US", "en-US") },
            { list -> handleMoviesSuccess(list, ::modifyUpcomingMoviesState) },
            ::onError,
        )
    }

    private fun modifyUpcomingMoviesState(state: HomeUiState, movies: List<Movie>): HomeUiState {
        return state.copy(upcomingMovies = movies.toUiState())
    }


    private fun getTopRatedMovies() {
        tryToExecute(
            { getTopRatedMoviesUsecase(1, "US", "en-US") },
            { list -> handleMoviesSuccess(list, ::modifyTopRatedMoviesState) },
            ::onError,
        )
    }

    private fun modifyTopRatedMoviesState(state: HomeUiState, movies: List<Movie>): HomeUiState {
        return state.copy(topRatedMovies = movies.toUiState())
    }

    private fun onError(throwable: Throwable) {
        val errors = _state.value?.error?.toMutableList() ?: mutableListOf()
        errors.add(throwable.message.toString())
        _state.value?.let { currentState ->
            _state.value = currentState.copy(error = errors, isLoading = false)
        }
    }

    override fun onClickMovie(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllMovie(homeItemsType: HomeUiState.HomeItem) {
        TODO("Not yet implemented")
    }
}