package com.red_velvet.flix.ui.movieDetails

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener

class MovieTopCastAdapter(
    topcast: MutableList<MovieUiState.TopCast>,
    listener: BaseInteractionListener
):BaseAdapter<MovieUiState.TopCast>(items = topcast , listener = listener) {
    override val layoutId: Int = R.layout.item_top_cast_movie_details
}