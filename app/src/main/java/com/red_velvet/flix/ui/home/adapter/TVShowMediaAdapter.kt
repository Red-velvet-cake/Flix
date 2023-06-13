package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.R
import com.red_velvet.flix.ui.home.HomeUiState

class TVShowMediaAdapter(
    items: List<HomeUiState.MediaUiState>, val listener: TvShowInteractionListener
) : BaseAdapter<HomeUiState.MediaUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_tvshow
}


interface TvShowInteractionListener : BaseInteractionListener {
    fun onClickTvShow(tvshowId: Int)
    fun onClickSeeAllTvShows(homeItem: HomeUiState.HomeItem)
}



