package com.red_velvet.flix.ui.home

import com.red_velvet.flix.domain.usecase.GetNowPlayingMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetPopularMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetTopRatedMoviesUsecase
import com.red_velvet.flix.domain.usecase.GetUpcomingMoviesUsecase
import com.red_velvet.flix.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPopularMoviesUsecase: GetPopularMoviesUsecase,
    private val getNowPlayingMoviesUsecase: GetNowPlayingMoviesUsecase,
    private val getUpcomingMoviesUsecase: GetUpcomingMoviesUsecase,
    private val getTopRatedMoviesUsecase: GetTopRatedMoviesUsecase,
) : BaseViewModel() {
}