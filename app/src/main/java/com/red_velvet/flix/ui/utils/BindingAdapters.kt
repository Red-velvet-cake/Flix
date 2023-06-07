package com.red_velvet.flix.ui.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.red_velvet.flix.R


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


@BindingAdapter("app:isVisible")
fun isVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}

@BindingAdapter("app:hideIfTrue")
fun hideIfTrue(view: View, value: Boolean) {
    view.isVisible = !value
}




@BindingAdapter("app:errorText")
fun showErrorAsString(view: TextView, error: List<String>) {
    view.text = error.joinToString("\n")
}
