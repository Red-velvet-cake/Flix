package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.MovieUiState
import com.red_velvet.flix.ui.home.TvShowUiState

class MediaAdapter<T, U : BaseInteractionListener>(
    items: List<T>, val listener: U, override val layoutId: Int
) : BaseAdapter<T>(items, listener)

interface MovieInteractionListener : BaseInteractionListener {
    fun onClickMovie(movieId: Int)
    fun onClickSeeAllMovie(movieTabItemsType: MovieUiState.MovieTabItem)
}

interface TvShowInteractionListener : BaseInteractionListener {
    fun onClickTvShow(tvshowId: Int)
    fun onClickSeeAllTvShows(tvShowTabItemsType: TvShowUiState.TvShowItem)
}

