package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.HomeUiState


interface PopularTvShowInteractionListener : BaseInteractionListener {
    fun onClickPopularTvShow(tvshowId: Int)
    fun onClickSeeAllPopularTvShows(homeItem: HomeUiState.HomeItem)
}


class PopularTVShowMediaAdapter(
    items: List<HomeUiState.MediaUiState>, val listener: PopularTvShowInteractionListener
) : BaseAdapter<HomeUiState.MediaUiState>(items, listener) {
    override val layoutId: Int = R.layout.popular_tvshow_item
}
