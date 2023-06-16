package com.red_velvet.flix.ui.movieDetails

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener

class MovieImagesAdapter(private val movieDetailsImages:MutableList<MovieUiState.ImageBelongToMovie>,
                         private val listener: BaseInteractionListener
):
    BaseAdapter<MovieUiState.ImageBelongToMovie>(movieDetailsImages,listener) {
    override val layoutId: Int = R.layout.item_image_belong_to_movie
}