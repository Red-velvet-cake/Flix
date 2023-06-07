package com.red_velvet.flix.ui.home

import androidx.lifecycle.viewModelScope
import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.usecase.GetNowPlayingMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetPopularMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetTopRatedMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetUpcomingMoviesUsecase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.home.adapter.MovieInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUsecase: GetPopularMoviesUsecase,
    private val getNowPlayingMoviesUsecase: GetNowPlayingMoviesUsecase,
    private val getUpcomingMoviesUsecase: GetUpcomingMoviesUsecase,
    private val getTopRatedMoviesUsecase: GetTopRatedMoviesUsecase,
) : BaseViewModel<HomeUiState>(), MovieInteractionListener {
    override val _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    override val state = _state
    val list: Flow<List<Movie>> = MutableStateFlow(
        listOf(
            Movie(
                1,
                "Title 1",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-1-3",
                0.0,
                "en",
            ),
            Movie(
                2,
                "Title 2",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-3-11",
                0.0,
                "ar",
            ),
            Movie(
                2,
                "Title 3",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-7-12",
                0.0,
                "ja",
            ),
            Movie(
                2,
                "Title 4",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-5-22",
                0.0,
                "ch"
            ),
            Movie(
                2,
                "Title 5",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-4-22",
                0.0,
                "ko"
            ),

            )
    )

    init {
        getHomeData()
    }

    fun getHomeData() {
        getPopularMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getTopRatedMovies()
    }

    private fun getPopularMovies() {
        tryToExecute(
            {
                list
//                getPopularMoviesUsecase(1, "US", "en-US")
            }, ::modifyPopularMoviesState, ::onError
        )

    }

    private fun modifyPopularMoviesState(movies: List<Movie>) {
        _state.update { oldState ->
            oldState.copy(
                popularMovies = mutableListOf(movies.first()).toUiState(),
                isLoading = false
            )
        }
    }

    private fun getNowPlayingMovies() {
        tryToExecute(
            {
                list
//                getNowPlayingMoviesUsecase(1, "US", "en-US")
            }, ::modifyNowPlayingMoviesState, ::onError
        )

    }

    private fun modifyNowPlayingMoviesState(movies: List<Movie>) {
        _state.update { oldState ->
            oldState.copy(nowPlayingMovies = movies.toUiState(), isLoading = false)
        }
    }

    private fun getUpcomingMovies() {
        tryToExecute(
            {
                list
//                getUpcomingMoviesUsecase(1, "US", "en-US")
            }, ::modifyUpcomingMoviesState, ::onError
        )

    }

    private fun modifyUpcomingMoviesState(movies: List<Movie>) {
        _state.update { oldState ->
            oldState.copy(upcomingMovies = movies.toUiState(), isLoading = false)
        }
    }

    private fun getTopRatedMovies() {
        tryToExecute(
            {
                list
//                getTopRatedMoviesUsecase(1, "US", "en-US")
            }, ::modifyTopRatedMoviesState, ::onError
        )

    }

    private fun modifyTopRatedMoviesState(movies: List<Movie>) {
        _state.update { oldState ->
            oldState.copy(topRatedMovies = movies.toUiState(), isLoading = false)
        }
    }

    private fun onError(throwable: Throwable) {
        val errors = mutableListOf<String>()
        errors.add(throwable.message.toString())
        _state.update { it.copy(error = errors, isLoading = false) }
    }

    override fun onClickMovie(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllMovie(homeItemsType: HomeUiState.HomeItem) {
        TODO("Not yet implemented")
    }

}