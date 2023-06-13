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

@BindingAdapter(value = ["app:hideWhenSearch"])
fun hideWhenSearch(view: View, text: String) {
    view.isVisible = text.isBlank()
}

@BindingAdapter(value = ["app:hideWhenBlankSearch"])
fun hideWhenBlankSearch(view: View, text: String) {
    if (text.isBlank()) {
        view.visibility = View.INVISIBLE
    }
}


@BindingAdapter(value = ["app:searchInput", "app:errorSearch", "app:loadingSearch"])
fun <T> hideWhenSuccessSearch(view: View, text: String, error: List<T>?, loading: Boolean) {
    view.visibility = if (text.isNotBlank() && error.isNullOrEmpty() && !loading) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
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

@BindingAdapter("app:isListEmpty")
fun showWhenDoneLoadingAndListIsEmpty(view: View, emptyList: Boolean) {
    view.isVisible = emptyList
}

@BindingAdapter("app:showWhenNoInternetError")
fun showWhenErrorNoInternetError(view: View, error: ErrorUiState?) {
    if (error != null && error.isNoInternet()) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("app:showWhenError")
fun showWhenError(view: View, error: ErrorUiState?) {
    if (error != null && error.isServerError() && error.isTimeOut()) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:error", "app:loading", "app:emptyResult"])
fun showWhenStart(
    view: View,
    error: ErrorUiState?,
    loading: Boolean,
    emptyResult: Boolean
) {
    if (error == null && !loading && emptyResult) {
        view.visibility = View.VISIBLE

    } else {
        view.visibility = View.GONE
    }
}