package com.red_velvet.flix.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.red_velvet.flix.R

@BindingAdapter("app:hideIfTrue")
fun hideIfTrue(view: View, value: Boolean) {
    view.isVisible = !value
}

@BindingAdapter("app:posterImage")
fun bindMovieImage(image: ImageView, imageURL: String?) {
    imageURL?.let {
        Glide.with(image.context)
            .load(imageURL)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_media_background)
            .into(image)
    }
}

