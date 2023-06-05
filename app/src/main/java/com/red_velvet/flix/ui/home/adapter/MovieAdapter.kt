package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.HomeUiState

class MovieAdapter(items: List<HomeUiState.MediaUiState>, val listener: MovieInteractionListener) :
    BaseAdapter<HomeUiState.MediaUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_movie
}

interface MovieInteractionListener : BaseInteractionListener {
    fun onClickMovie(movieId: Int)
    fun onClickSeeAllMovie(homeItemsType: HomeUiState.HomeItem)
}

