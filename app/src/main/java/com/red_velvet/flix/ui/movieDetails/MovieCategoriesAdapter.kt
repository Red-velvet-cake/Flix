package com.red_velvet.flix.ui.movieDetails

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener

class MovieCategoriesAdapter(
    private val categories:List<MovieUiState.MovieKeywords>,
    private val listener: BaseInteractionListener
):BaseAdapter<MovieUiState.MovieKeywords>(categories,listener) {
    override val layoutId: Int = R.layout.item_category_movie_details
}