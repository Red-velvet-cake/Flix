package com.red_velvet.flix.ui.home.homeUiState

import com.red_velvet.flix.ui.home.HomeItem

data class HomeUiState(
    val popularMovies: HomeItem = HomeItem.Popular(emptyList()),
    val airingTodayMovies: HomeItem = HomeItem.AiringToday(emptyList()),
    val onTvMovies: HomeItem = HomeItem.OnTv(emptyList()),
    val topRatedMovies: HomeItem = HomeItem.TopRated(emptyList()),
    val isLoading: Boolean = false,
    val error: List<String> = emptyList(),
)