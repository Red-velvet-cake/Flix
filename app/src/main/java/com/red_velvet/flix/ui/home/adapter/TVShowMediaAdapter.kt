package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.TvShowUiState
import com.red_velvet.flix.R

class TVShowMediaAdapter(
    items: List<TvShowUiState.MediaUiState>, val listener: TvShowInteractionListener
) : BaseAdapter<TvShowUiState.MediaUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_tvshow
}


interface TvShowInteractionListener : BaseInteractionListener {
    fun onClickTvShow(tvshowId: Int)
    fun onClickSeeAllTvShows(tvShowTabItemsType: TvShowUiState.TvShowItem)
}

