package com.red_velvet.flix.ui.home

import android.util.Log
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
import com.red_velvet.flix.ui.home.adapters.MovieInteractionListener
import com.red_velvet.flix.ui.home.adapters.PopularMovieInteractionListener
import com.red_velvet.flix.ui.home.adapters.PopularTvShowInteractionListener
import com.red_velvet.flix.ui.home.adapters.TvShowInteractionListener
import com.red_velvet.flix.ui.utils.toMovieUiState
import com.red_velvet.flix.ui.utils.toSeriesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMovies: GetPopularMoviesUseCase,
    private val getNowPlayingMovies: GetNowPlayingMoviesUseCase,
    private val getUpcomingMovies: GetUpcomingMoviesUseCase,
    private val getTopRatedMovies: GetTopRatedMoviesUseCase,
    private val getPopularSeries: GetPopularSeriesUseCase,
    private val getAiringTodaySeries: GetAiringTodaySeriesUseCase,
    private val getOnTheAirSeries: GetOnTheAirSeriesUseCase,
    private val getTopRatedSeries: GetTopRatedSeriesUseCase,

    ) : BaseViewModel<HomeUiState>(), MovieInteractionListener, PopularMovieInteractionListener,
    TvShowInteractionListener, PopularTvShowInteractionListener {
    override val _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    override val state = _state

    init {
        getMoviesPageData()
    }

    fun getMoviesPageData() {
        _state.update { it.copy(movieError = null,isMovieLoading = true) }
        getPopularMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getTopRatedMovies()
    }

    fun getTvShowsPageData() {
        _state.update { it.copy(seriesError = null, isSeriesLoading = true) }
        getPopularSeries()
        getAiringTodaySeries()
        getOnAirSeries()
        getTopRatedSeries()
    }


    private fun getPopularMovies() {
        tryToExecute(
            getPopularMovies::invoke,
            ::modifyPopularMoviesState,
            ::onMovieError
        )

    }

    private fun modifyPopularMoviesState(movies: List<MovieEntity>) {
        Log.d("RESPONSE", "modifyPopularMoviesState: ${movies.size}")
        _state.update {
            it.copy(
                popularMovies = mutableListOf(movies.first()).toMovieUiState(),
                isMovieLoading = false
            )
        }
    }

    private fun getNowPlayingMovies() {
        tryToExecute(
            getNowPlayingMovies::invoke,
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
            getUpcomingMovies::invoke,
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
            getTopRatedMovies::invoke,
            ::modifyTopRatedMoviesState, ::onMovieError
        )

    }

    private fun modifyTopRatedMoviesState(movies: List<MovieEntity>) {
        _state.update {
            it.copy(topRatedMovies = movies.toMovieUiState(), isMovieLoading = false)
        }
    }

    private fun onMovieError(errorUiState: ErrorUiState) {
        Log.e("RESPONSE", "onMovieError: $errorUiState")
        _state.update { it.copy(movieError = errorUiState, isMovieLoading = false) }
    }

    private fun getPopularSeries() {
        tryToExecute(
            getPopularSeries::invoke,
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
            getAiringTodaySeries::invoke,
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
            getOnTheAirSeries::invoke,
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
            getTopRatedSeries::invoke,
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
        _state.update { it.copy(seriesError = errorUiState, isSeriesLoading = false) }
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