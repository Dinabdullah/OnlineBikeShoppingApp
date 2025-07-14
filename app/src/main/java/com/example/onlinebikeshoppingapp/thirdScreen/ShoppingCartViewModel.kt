package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.lifecycle.ViewModel
import com.example.onlinebikeshoppingapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ShoppingCartViewModel : ViewModel() {

    private val _itemCounts = mutableMapOf<Int, MutableStateFlow<Int>>()

    val items = listOf(
        BikeItem(1, R.drawable.bike1, R.string.title1, R.string.price1),
        BikeItem(2, R.drawable.bike2, R.string.title2, R.string.price2),
        BikeItem(3, R.drawable.bike3, R.string.title3, R.string.price3)
    )

    fun getCount(itemId: Int): StateFlow<Int> {
        return _itemCounts.getOrPut(itemId) { MutableStateFlow(1) }
    }

    fun increase(itemId: Int) {
        val count = _itemCounts.getOrPut(itemId) { MutableStateFlow(1) }
        count.value++
    }

    fun decrease(itemId: Int) {
        val count = _itemCounts.getOrPut(itemId) { MutableStateFlow(1) }
        if (count.value > 0) count.value--
    }
}
