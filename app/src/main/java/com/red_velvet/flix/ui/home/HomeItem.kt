package com.red_velvet.flix.ui.home

import com.red_velvet.flix.ui.home.homeUiState.MediaUiState

sealed class HomeItem(val priority: Int) {
    data class Popular(val items: List<MediaUiState>, val type: HomeItemsType = HomeItemsType.POPULAR) :
        HomeItem(0)

    data class NowPlaying(
        val items: List<MediaUiState>,
        val type: HomeItemsType = HomeItemsType.NOW_PLAYING
    ) : HomeItem(1)

    data class Upcoming(val items: List<MediaUiState>, val type: HomeItemsType = HomeItemsType.UPCOMING) :
        HomeItem(2)

    data class TopRated(val items: List<MediaUiState>, val type: HomeItemsType = HomeItemsType.TOP_RATED) :
        HomeItem(35)
}