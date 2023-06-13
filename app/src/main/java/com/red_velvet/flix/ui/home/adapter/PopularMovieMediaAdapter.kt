package com.red_velvet.flix.ui.home.adapter

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.MovieUiState

class PopularMovieMediaAdapter(
    items: List<MovieUiState.MediaUiState>,
    val listener: PopularMovieInteractionListener
) :
    BaseAdapter<MovieUiState.MediaUiState>(items, listener) {
    override val layoutId: Int = R.layout.popular_movie_item
}

interface PopularMovieInteractionListener : BaseInteractionListener {
    fun onClickPopularMovie(movieId: Int)
    fun onClickSeeAllPopularMovies(homeItemsType: MovieUiState.MovieTabItem)
}