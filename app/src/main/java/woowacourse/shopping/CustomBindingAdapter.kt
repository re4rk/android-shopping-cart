package woowacourse.shopping

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import woowacourse.shopping.ui.customView.ProductCounter

object CustomBindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageResource(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(view)
    }

    fun interface OnCountChangeListener {
        fun onCountChange(productId: Int, count: Int)
    }

    @BindingAdapter("productCounterListener", requireAll = true)
    @JvmStatic
    fun onProductCountChange(view: ProductCounter, listener: OnCountChangeListener) {
        view.setOnCountChangeListener { productId, it ->
            listener.onCountChange(productId, it)
        }
    }
}
