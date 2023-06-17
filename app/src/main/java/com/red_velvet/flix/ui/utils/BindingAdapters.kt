package com.red_velvet.flix.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.bumptech.glide.Glide
import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.home.HomeUiState

@BindingAdapter("app:posterImage")
fun bindMovieImage(image: ImageView, imageURL: String?) {
    imageURL.let {
        Glide.with(image.context).load(imageURL).placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_media_background).into(image)
    }
}


@BindingAdapter("app:isVisible")
fun isVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}

@BindingAdapter("setHelperText")
fun TextInputLayout.setHelperText(helperText: String) {
    this.helperText = helperText
}

@BindingAdapter("app:showMovieContentOnSuccess")
fun showMovieContentOnSuccess(view: View, state: HomeUiState?) {
    if (state != null) {
        view.isVisible = state.isMovieLoading == false && state.movieError == null
    }
}


@BindingAdapter("app:showSeriesContentOnSuccess")
fun showSeriesContentOnSuccess(view: View, state: HomeUiState?) {
    if (state != null) {
        view.isVisible = state.isSeriesLoading == false && state.seriesError == null
    }
}


@BindingAdapter("app:showOnError")
fun showOnError(view: View, error: ErrorUiState?) {
    if (error != null) {
        view.isVisible = !error.isNoInternet()
    } else {
        view.isVisible = false
    }

}


@BindingAdapter("app:showLoading")
fun showLoading(view: View, loading: Boolean?) {
    view.isVisible = loading == true
}


@BindingAdapter("app:showWhenNoInternet")
fun showWhenNoInternet(view: View, error: ErrorUiState?) {
    if (error != null) {
        view.isVisible = error.isNoInternet()
    }
}
