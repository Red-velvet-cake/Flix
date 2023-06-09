package com.red_velvet.flix.ui.home.homeUiState

import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.home.HomeItem

data class HomeUiState(
    val popularMovies: HomeItem = HomeItem.Popular(emptyList()),
    val nowPlayingMovies: HomeItem = HomeItem.NowPlaying(emptyList()),
    val upcomingMovies: HomeItem = HomeItem.Upcoming(emptyList()),
    val topRatedMovies: HomeItem = HomeItem.TopRated(emptyList()),
    val isLoading: Boolean = false,
    val error: List<String> = emptyList(),
) : BaseUiState