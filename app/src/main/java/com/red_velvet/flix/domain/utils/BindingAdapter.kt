import android.view.View
import androidx.databinding.BindingAdapter
import com.red_velvet.flix.ui.base.ErrorUiState

@BindingAdapter("app:showWhenNoInternetError")
fun showWhenErrorNoInternetError(view: View, error: ErrorUiState?) {
    if (error != null && error.isNoInternet()) {
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