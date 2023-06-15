package com.red_velvet.flix.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.red_velvet.flix.R
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.ui.movieDetails.MovieDetailsAdapter
import com.red_velvet.flix.ui.movieDetails.MovieUiState

@BindingAdapter("app:hideIfTrue")
fun hideIfTrue(view: View, value: Boolean) {
    view.isVisible = !value
}
@BindingAdapter(value = ["app:imageUrl"])
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view).load(url)
        .fitCenter()
        .centerCrop()
        .into(view)
}
@BindingAdapter(value = ["app:items"])
fun setRecyclerViewItems(view: RecyclerView , items : List<MovieUiState.MovieList>){
    (view.adapter as MovieDetailsAdapter).setItems(items)
}
