package com.red_velvet.flix.ui.movieDetails

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener


class MovieDetailsAdapter
    (private val movieDetailsItems:MutableList<MovieUiState.MovieList>,
     private val listener: BaseInteractionListener):
    BaseAdapter<MovieUiState.MovieList>(movieDetailsItems,listener) {
    override val layoutId: Int = R.layout.item_movies_details
}
interface ItemMovieInteractionListener:BaseInteractionListener{
    fun onMovieItemClick(movieId: Int)
}
