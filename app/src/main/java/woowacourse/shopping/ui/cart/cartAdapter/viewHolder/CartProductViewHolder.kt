package woowacourse.shopping.ui.cart.cartAdapter.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import woowacourse.shopping.databinding.ItemCartBinding
import woowacourse.shopping.ui.cart.cartAdapter.CartItemType
import woowacourse.shopping.ui.cart.cartAdapter.CartListener

class CartProductViewHolder private constructor(
    private val binding: ItemCartBinding,
    private val cartListener: CartListener
) : CartViewHolder(binding.root) {
    init {
        binding.listener = cartListener
    }
    override fun bind(data: CartItemType) {
        if (data !is CartItemType.Cart) return
        binding.product = data.product
        binding.cvProductCounter.minCount = 1
        binding.cvProductCounter.setOnClickListener {
            cartListener.onItemUpdate(data.product.id, it)
        }
        binding.cbProductCheck.setOnCheckedChangeListener { _, isChecked ->
            cartListener.onItemCheckChanged(data.product.id, isChecked)
        }
    }

    companion object {
        fun from(parent: ViewGroup, cartListener: CartListener): CartProductViewHolder {
            val binding = ItemCartBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return CartProductViewHolder(binding, cartListener)
        }
    }
}