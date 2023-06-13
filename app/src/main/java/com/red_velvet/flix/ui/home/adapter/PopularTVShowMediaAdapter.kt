package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.TvShowUiState


interface PopularTvShowInteractionListener : BaseInteractionListener {
    fun onClickPopularTvShow(tvshowId: Int)
    fun onClickSeeAllPopularTvShows(tvshowTabItemsType: TvShowUiState.TvShowItem)
}


class PopularTVShowMediaAdapter(
    items: List<TvShowUiState.MediaUiState>, val listener: PopularTvShowInteractionListener
) : BaseAdapter<TvShowUiState.MediaUiState>(items, listener) {
    override val layoutId: Int = R.layout.popular_tvshow_item
}
