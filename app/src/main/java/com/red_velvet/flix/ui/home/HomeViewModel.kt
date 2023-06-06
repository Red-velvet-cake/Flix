package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.usecase.GetNowPlayingMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetPopularMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetTopRatedMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetUpcomingMoviesUsecase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.home.adapter.MovieInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
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
                "go go go",
                0.0,
            ),
            Movie(
                2,
                "Title 2",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "go go go",
                0.0,
            ),
            Movie(
                2,
                "Title 3",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "go go go",
                0.0,
            ),
            Movie(
                2,
                "Title 4",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "go go go",
                0.0,
            ),
            Movie(
                2,
                "Title 5",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "go go go",
                0.0,
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
            },
            { list -> handleMoviesSuccess(list, ::modifyPopularMoviesState) },
            ::onError,
        )
    }

    private fun modifyPopularMoviesState(state: HomeUiState, movies: List<Movie>): HomeUiState {
        return state.copy(popularMovies = movies.toUiState(), isLoading = false)
    }

    private fun getNowPlayingMovies() {
        tryToExecute(
            {
                list
//                getNowPlayingMoviesUsecase(1, "US", "en-US")
            },
            { list -> handleMoviesSuccess(list, ::modifyNowPlayingMoviesState) },
            ::onError,
        )
    }

    private fun modifyNowPlayingMoviesState(state: HomeUiState, movies: List<Movie>): HomeUiState {
        return state.copy(nowPlayingMovies = movies.toUiState(), isLoading = false)
    }

    private fun getUpcomingMovies() {
        tryToExecute(
            {
                list
//                getUpcomingMoviesUsecase(1, "US", "en-US")
            },
            { list -> handleMoviesSuccess(list, ::modifyUpcomingMoviesState) },
            ::onError,
        )
    }

    private fun modifyUpcomingMoviesState(state: HomeUiState, movies: List<Movie>): HomeUiState {
        return state.copy(upcomingMovies = movies.toUiState(), isLoading = false)
    }

    private fun getTopRatedMovies() {
        tryToExecute(
            {
                list
//                getTopRatedMoviesUsecase(1, "US", "en-US")
            },
            { list -> handleMoviesSuccess(list, ::modifyTopRatedMoviesState) },
            ::onError,
        )
    }

    private fun modifyTopRatedMoviesState(state: HomeUiState, movies: List<Movie>): HomeUiState {
        return state.copy(topRatedMovies = movies.toUiState(), isLoading = false)
    }

    private fun onError(throwable: Throwable) {
        val errors = state.value.error.toMutableList() ?: mutableListOf()
        errors.add(throwable.message.toString())
        state.value.let { currentState ->
            state.value = currentState.copy(error = errors, isLoading = false)
        }
    }

    override fun onClickMovie(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllMovie(homeItemsType: HomeUiState.HomeItem) {
        TODO("Not yet implemented")
    }

}