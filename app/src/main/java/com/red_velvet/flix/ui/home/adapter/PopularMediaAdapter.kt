package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.MovieUiState
import com.red_velvet.flix.ui.home.TvShowUiState

class PopularMediaAdapter<T, U: BaseInteractionListener>(
    items: List<T>,
    val listener: U,
    override val layoutId: Int
) :
    BaseAdapter<T>(items, listener)

interface PopularMovieInteractionListener : BaseInteractionListener {
    fun onClickPopularMovie(movieId: Int)
    fun onClickSeeAllPopularMovies(movieTabItemsType: MovieUiState.MovieTabItem)
}


interface PopularTvShowInteractionListener : BaseInteractionListener {
    fun onClickPopularTvShow(tvshowId: Int)
    fun onClickSeeAllPopularTvShows(tvshowTabItemsType: TvShowUiState.TvShowItem)
}

