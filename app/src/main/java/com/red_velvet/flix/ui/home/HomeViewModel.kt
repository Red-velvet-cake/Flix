package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.usecase.GetAiringTodaySeriesUseCase
import com.red_velvet.flix.domain.usecase.GetNowPlayingMoviesUseCase
import com.red_velvet.flix.domain.usecase.GetOnTheAirSeriesUseCase
import com.red_velvet.flix.domain.usecase.GetPopularMoviesUseCase
import com.red_velvet.flix.domain.usecase.GetPopularSeriesUseCase
import com.red_velvet.flix.domain.usecase.GetTopRatedMoviesUseCase
import com.red_velvet.flix.domain.usecase.GetTopRatedSeriesUseCase
import com.red_velvet.flix.domain.usecase.GetUpcomingMoviesUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.home.adapter.MovieInteractionListener
import com.red_velvet.flix.ui.home.adapter.PopularMovieInteractionListener
import com.red_velvet.flix.ui.home.adapter.PopularTvShowInteractionListener
import com.red_velvet.flix.ui.home.adapter.TvShowInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUsecase: GetPopularMoviesUseCase,
    private val getNowPlayingMoviesUsecase: GetNowPlayingMoviesUseCase,
    private val getUpcomingMoviesUsecase: GetUpcomingMoviesUseCase,
    private val getTopRatedMoviesUsecase: GetTopRatedMoviesUseCase,
    private val getPopularSeriesUseCase: GetPopularSeriesUseCase,
    private val getAiringTodaySeriesUseCase: GetAiringTodaySeriesUseCase,
    private val getOnTheAirSeriesUseCase: GetOnTheAirSeriesUseCase,
    private val getTopRatedSeriesUseCase: GetTopRatedSeriesUseCase,

    ) : BaseViewModel<HomeUiState>(), MovieInteractionListener, PopularMovieInteractionListener,
    TvShowInteractionListener, PopularTvShowInteractionListener {
    override val _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    override val state = _state

    private val list: List<MovieEntity> = listOf(
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
            "https://image.tmdb.org/t/p/w500/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
            0.0,
            "2022-3-11",
            0.0,
            "ar",
        ),
        MovieEntity(
            2,
            "Title 3",
            "https://image.tmdb.org/t/p/w500/9ijMGlJKqcslswWUzTEwScm82Gs.jpg",
            0.0,
            "2022-7-12",
            0.0,
            "ja",
        ),
        MovieEntity(
            2,
            "Title 4",
            "https://image.tmdb.org/t/p/w500/1f3qspv64L5FXrRy0MF8X92ieuw.jpg",
            0.0,
            "2022-5-22",
            0.0,
            "ch"
        ),
        MovieEntity(
            2,
            "Title 5",
            "https://image.tmdb.org/t/p/w500/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
            0.0,
            "2022-4-22",
            0.0,
            "ko"
        ),

        )
    private val list2: List<SeriesEntity> = listOf(
        SeriesEntity(
            1,
            "Title 1",
            "https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
            "2022-1-3",
            0.0,
            0.0,
        ),
        SeriesEntity(
            2,
            "Title 2",
            "https://image.tmdb.org/t/p/w500/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
            "2022-3-11",
            0.0,
            0.0,
        ),
        SeriesEntity(
            2,
            "Title 3",
            "https://image.tmdb.org/t/p/w500/9ijMGlJKqcslswWUzTEwScm82Gs.jpg",
            "2022-7-12",
            0.0,
            0.0,
        ),
        SeriesEntity(
            2,
            "Title 4",
            "https://image.tmdb.org/t/p/w500/1f3qspv64L5FXrRy0MF8X92ieuw.jpg",
            "2022-5-22",
            0.0,
            0.0,
        ),
        SeriesEntity(
            2,
            "Title 5",
            "https://image.tmdb.org/t/p/w500/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
            "2022-4-22",
            0.0,
            0.0,

            ),

        )

    init {
        getMoviesPageData()
    }

    fun getMoviesPageData() {
        _state.update { it.copy(isMovieLoading = true) }
        getPopularMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getTopRatedMovies()
    }

    fun getTvShowsPageData() {
        _state.update { it.copy(isSeriesLoading = true) }
        getPopularSeries()
        getAiringTodaySeries()
        getOnAirSeries()
        getTopRatedSeries()
    }


    private fun getPopularMovies() {
        tryToExecute(
            { list },
//            getPopularMoviesUsecase::invoke,
            ::modifyPopularMoviesState, ::onMovieError
        )

    }

    private fun modifyPopularMoviesState(movies: List<MovieEntity>) {
        _state.update {
            it.copy(
                popularMovies = mutableListOf(movies.first()).toMovieUiState(),
                isMovieLoading = false
            )
        }
    }

    private fun getNowPlayingMovies() {
        tryToExecute(
            { list },
//            getNowPlayingMoviesUsecase::invoke,
            ::modifyNowPlayingMoviesState, ::onMovieError
        )

    }

    private fun modifyNowPlayingMoviesState(movies: List<MovieEntity>) {
        _state.update {
            it.copy(nowPlayingMovies = movies.toMovieUiState(), isMovieLoading = false)
        }
    }

    private fun getUpcomingMovies() {
        tryToExecute(
            { list },
//            getUpcomingMoviesUsecase::invoke,
            ::modifyUpcomingMoviesState, ::onMovieError
        )

    }

    private fun modifyUpcomingMoviesState(movies: List<MovieEntity>) {
        _state.update {
            it.copy(upcomingMovies = movies.toMovieUiState(), isMovieLoading = false)
        }
    }

    private fun getTopRatedMovies() {
        tryToExecute(
            { list },
//            getTopRatedMoviesUsecase::invoke,
            ::modifyTopRatedMoviesState, ::onMovieError
        )

    }

    private fun modifyTopRatedMoviesState(movies: List<MovieEntity>) {
        _state.update {
            it.copy(topRatedMovies = movies.toMovieUiState(), isMovieLoading = false)
        }
    }

    private fun onMovieError(errorUiState: ErrorUiState) {
        val errors = mutableListOf<String>()
        errors.add(errorUiState.toString())
        _state.update { it.copy(movieError = errors, isMovieLoading = false) }
    }

    private fun getPopularSeries() {
        tryToExecute(
            { list2 },
//            getPopularSeriesUseCase::invoke,
            ::modifyPopularSeriesState, ::onSeriesError
        )
    }

    private fun modifyPopularSeriesState(series: List<SeriesEntity>) {
        _state.update {
            it.copy(
                popularSeries = mutableListOf(series.first()).toSeriesUiState(),
                isSeriesLoading = false
            )
        }
    }


    private fun getAiringTodaySeries() {
        tryToExecute(
            { list2 },
//            getAiringTodaySeriesUseCase::invoke,
            ::modifyAiringTodaySeriesState, ::onSeriesError
        )
    }

    private fun modifyAiringTodaySeriesState(series: List<SeriesEntity>) {
        _state.update {
            it.copy(
                airingTodaySeries = series.toSeriesUiState(), isSeriesLoading = false
            )
        }
    }


    private fun getOnAirSeries() {
        tryToExecute(
            { list2 },
//            getOnTheAirSeriesUseCase::invoke,
            ::modifyOnAirSeriesState, ::onSeriesError
        )
    }

    private fun modifyOnAirSeriesState(series: List<SeriesEntity>) {
        _state.update {
            it.copy(
                onTVSeries = series.toSeriesUiState(), isSeriesLoading = false
            )
        }
    }


    private fun getTopRatedSeries() {
        tryToExecute(
            { list2 },
//            getTopRatedSeriesUseCase::invoke,
            ::modifyTopRatedSeriesState, ::onSeriesError
        )
    }

    private fun modifyTopRatedSeriesState(series: List<SeriesEntity>) {
        _state.update {
            it.copy(
                topRatedSeries = series.toSeriesUiState(), isSeriesLoading = false
            )
        }
    }


    private fun onSeriesError(errorUiState: ErrorUiState) {
        val errors = mutableListOf<String>()
        errors.add(errorUiState.toString())
        _state.update { it.copy(seriesError = errors, isSeriesLoading = false) }
    }


    override fun onClickMovie(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllMovie(homeItem: HomeUiState.HomeItem) {
        TODO("Not yet implemented")
    }

    override fun onClickPopularMovie(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllPopularMovies(homeItem: HomeUiState.HomeItem) {
        TODO("Not yet implemented")
    }

    override fun onClickTvShow(tvshowId: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllTvShows(homeItem: HomeUiState.HomeItem) {
        TODO("Not yet implemented")
    }

    override fun onClickPopularTvShow(tvshowId: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllPopularTvShows(homeItem: HomeUiState.HomeItem) {
        TODO("Not yet implemented")
    }

}