package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.MovieUiState

interface MovieInteractionListener : BaseInteractionListener {
    fun onClickMovie(movieId: Int)
    fun onClickSeeAllMovie(movieTabItemsType: MovieUiState.MovieTabItem)
}


class MovieMediaAdapter(
    items: List<MovieUiState.MediaUiState>, val listener: MovieInteractionListener
) : BaseAdapter<MovieUiState.MediaUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_movie
}


