package com.red_velvet.flix.domain.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.ErrorUiState

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
    view.scrollToPosition(0)
}

@BindingAdapter(value = ["app:showWhenSearch"])
fun showWhenSearch(view: View, text: String) {
    view.isVisible = text.isNotBlank()
}


@BindingAdapter(value = ["app:imageURL"])
fun setImage(view: ImageView, imageUrl: String?) {
    Glide.with(view)
        .load(imageUrl)
        .thumbnail(Glide.with(view).load(R.drawable.loading))
        .fitCenter()
        .centerCrop()
        .into(view)
}

@BindingAdapter("app:isVisible")
fun isVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}


@BindingAdapter("app:showWhenNoInternetError")
fun showWhenErrorNoInternetError(view: View, error: ErrorUiState?) {
    if (error != null && error.isNoInternet()) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:emptyResult", "app:searchInput", "app:errorNoResult"])
fun showEmptySearchResultError(view: View, emptyResult: Boolean, text: String, error: ErrorUiState?) {
    if (emptyResult && text.isNotBlank() && error == null) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}



@BindingAdapter(value = ["app:errorNoInput", "app:emptyInput", "app:loading"])
fun showWhenStart(
    view: View,
    error: ErrorUiState?,
    emptyInput: Boolean,
    loading: Boolean
) {
    if (error == null && emptyInput && !loading) {
        view.visibility = View.VISIBLE

    } else {
        view.visibility = View.GONE
    }
}