package woowacourse.shopping.repository

import woowacourse.shopping.model.CartProducts

interface CartRepository {
    fun getPage(index: Int, size: Int): CartProducts
    fun hasNextPage(index: Int, size: Int): Boolean
    fun hasPrevPage(index: Int, size: Int): Boolean
    fun getTotalCount(): Int
    fun insert(productId: Int)
    fun remove(id: Int)
    fun updateCount(id: Int, count: Int): Int
    fun updateSelected(id: Int, selected: Boolean)
}
