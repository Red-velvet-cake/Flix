package com.red_velvet.flix.ui.review

import com.red_velvet.flix.R
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener

class ReviewAdapter(items: List<ReviewEntity>, listener: ReviewMovieInteractionListener) :
    BaseAdapter<ReviewEntity>(items, listener) {
    override val layoutId: Int = R.layout.item_movie_review
}

interface ReviewMovieInteractionListener : BaseInteractionListener {
    fun onClickCardReview()
}