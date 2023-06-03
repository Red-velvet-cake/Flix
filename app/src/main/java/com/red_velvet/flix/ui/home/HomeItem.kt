package com.red_velvet.flix.ui.home

import com.red_velvet.flix.ui.home.homeUiState.MediaUiState

sealed class HomeItem(val priority: Int) {
    data class Popular(val items: List<MediaUiState>, val type: HomeItemsType = HomeItemsType.POPULAR) :
        HomeItem(0)

    data class AiringToday(
        val items: List<MediaUiState>,
        val type: HomeItemsType = HomeItemsType.AIRING_TODAY
    ) : HomeItem(1)

    data class OnTv(val items: List<MediaUiState>, val type: HomeItemsType = HomeItemsType.ON_TV) :
        HomeItem(2)

    data class TopRated(val items: List<MediaUiState>, val type: HomeItemsType = HomeItemsType.TOP_RATED) :
        HomeItem(35)
}