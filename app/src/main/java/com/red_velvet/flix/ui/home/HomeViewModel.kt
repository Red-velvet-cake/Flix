package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.usecase.GetNowPlayingMoviesUseCase
import com.red_velvet.flix.domain.usecase.GetPopularMoviesUseCase
import com.red_velvet.flix.domain.usecase.GetTopRatedMoviesUseCase
import com.red_velvet.flix.domain.usecase.GetUpcomingMoviesUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.home.adapter.MovieInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUsecase: GetPopularMoviesUseCase,
    private val getNowPlayingMoviesUsecase: GetNowPlayingMoviesUseCase,
    private val getUpcomingMoviesUsecase: GetUpcomingMoviesUseCase,
    private val getTopRatedMoviesUsecase: GetTopRatedMoviesUseCase,
) : BaseViewModel<HomeUiState>(), MovieInteractionListener {
    override val _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    override val state = _state
    val list: Flow<List<MovieEntity>> = MutableStateFlow(
        listOf(
            MovieEntity(
                1,
                "Title 1",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-1-3",
                0.0,
                "en",
            ),
            MovieEntity(
                2,
                "Title 2",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-3-11",
                0.0,
                "ar",
            ),
            MovieEntity(
                2,
                "Title 3",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-7-12",
                0.0,
                "ja",
            ),
            MovieEntity(
                2,
                "Title 4",
                "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                0.0,
                "2022-5-22",
                0.0,
                "ch"
            ),
            MovieEntity(
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

    private fun modifyPopularMoviesState(movies: List<MovieEntity>) {
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

    private fun modifyNowPlayingMoviesState(movies: List<MovieEntity>) {
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

    private fun modifyUpcomingMoviesState(movies: List<MovieEntity>) {
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

    private fun modifyTopRatedMoviesState(movies: List<MovieEntity>) {
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