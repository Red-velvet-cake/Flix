package com.red_velvet.flix.ui.movieDetails

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener

class ReviewMovieDetailsAdapter(
    reviews: MutableList<MovieUiState.MovieReview>,
    listener: BaseInteractionListener):
    BaseAdapter<MovieUiState.MovieReview>(items = reviews , listener = listener) {
    override val layoutId: Int = R.layout.item_review_movie_details
}