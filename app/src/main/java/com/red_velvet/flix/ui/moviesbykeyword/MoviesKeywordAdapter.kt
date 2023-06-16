package com.red_velvet.flix.ui.moviesbykeyword

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.moviesbykeyword.uiState.MovieUiState

class MoviesKeywordAdapter (items: List<MovieUiState>, listener: MovieInteractionListener) :
    BaseAdapter<MovieUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_movie_keyword
}

interface MovieInteractionListener : BaseInteractionListener {
    fun onMovieClick(id: Int)
}