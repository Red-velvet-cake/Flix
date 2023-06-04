import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("app:hideIfTrue")
fun hideIfTrue(view: View, value: Boolean) {
    view.isVisible = !value
}
