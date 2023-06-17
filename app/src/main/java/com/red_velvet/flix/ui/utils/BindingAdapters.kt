package com.red_velvet.flix.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.red_velvet.flix.ui.movieDetails.MovieCategoriesAdapter
import com.red_velvet.flix.ui.movieDetails.MovieImagesAdapter
import com.red_velvet.flix.ui.movieDetails.MovieDetailsAdapter
import com.red_velvet.flix.ui.movieDetails.MovieKeywordsAdapter
import com.red_velvet.flix.ui.movieDetails.MovieTopCastAdapter
import com.red_velvet.flix.ui.movieDetails.MovieUiState
import com.red_velvet.flix.ui.movieDetails.ReviewMovieDetailsAdapter

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
fun setRecyclerViewItems(view: RecyclerView , items : List<MovieUiState.MovieList>?){
    items?.let { (view.adapter as MovieDetailsAdapter).setItems(items)}
}
@BindingAdapter(value = ["app:itemsReview"])
fun setRecyclerViewItemsReview(view: RecyclerView , items : List<MovieUiState.MovieReview>?){
    items?.let { (view.adapter as ReviewMovieDetailsAdapter).setItems(items)}
}
@BindingAdapter(value = ["app:itemsImagesBelongToMovie"])
fun setRecyclerViewItemsImages(view: RecyclerView , items : List<MovieUiState.ImageBelongToMovie>?){
    items?.let { (view.adapter as MovieImagesAdapter).setItems(items)}
}
@BindingAdapter(value = ["app:itemsTopCast"])
fun setRecyclerViewItemsTopCast(view: RecyclerView , items : List<MovieUiState.TopCast>?){
    items?.let { (view.adapter as MovieTopCastAdapter).setItems(items)}
}
@BindingAdapter(value = ["app:itemsMovieKeyword"])
fun setRecyclerViewItemsMovieKeywords(view: RecyclerView , items : List<MovieUiState.MovieKeywords>?){
    items?.let { (view.adapter as MovieKeywordsAdapter).setItems(items)}
}
@BindingAdapter(value = ["app:itemsMovieCategories"])
fun setRecyclerViewItemsMovieCategories(view: RecyclerView , items : List<MovieUiState.MovieKeywords>?){
    items?.let { (view.adapter as MovieCategoriesAdapter).setItems(items)}
}


