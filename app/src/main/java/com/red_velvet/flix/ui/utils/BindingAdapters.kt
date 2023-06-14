package com.red_velvet.flix.ui.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.bumptech.glide.Glide
import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.home.HomeUiState
import java.text.SimpleDateFormat
import java.util.Locale

@BindingAdapter("app:formattedDate", "app:language", requireAll = true)
fun bindFormattedDateWithCountryCode(view: TextView, rawDate: String?, languageCode: String?) {
    if (rawDate.isNullOrEmpty() || languageCode.isNullOrEmpty()) {
        view.text = ""
        return
    }
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val date = inputFormat.parse(rawDate)
    val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    val formattedDate = outputFormat.format(date!!)

    view.text = "$formattedDate (${languageCode.uppercase()})"
}


@BindingAdapter("app:posterImage")
fun bindMovieImage(image: ImageView, imageURL: String?) {
    imageURL?.let {
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
        if (state.isMovieLoading == false && state.movieError == null) {
            view.isVisible = true
        } else {
            view.isVisible = false
        }
    }
}


@BindingAdapter("app:showSeriesContentOnSuccess")
fun showSeriesContentOnSuccess(view: View, state: HomeUiState?) {
    if (state != null) {
        if (state.isSeriesLoading == false && state.seriesError == null) {
            view.isVisible = true
        } else {
            view.isVisible = false
        }
    }
}


@BindingAdapter("app:showOnError")
fun showOnError(view: View, error: ErrorUiState?) {
    view.isVisible = error != null
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
