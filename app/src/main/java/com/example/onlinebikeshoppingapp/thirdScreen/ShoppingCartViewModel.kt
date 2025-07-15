package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.lifecycle.ViewModel
import com.example.onlinebikeshoppingapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ShoppingCartViewModel : ViewModel() {

    private val _items = MutableStateFlow(
        listOf(
            BikeItem(1, R.drawable.bike1, R.string.title1, R.string.price1),
            BikeItem(2, R.drawable.bike2, R.string.title2, R.string.price2),
            BikeItem(3, R.drawable.bike3, R.string.title3, R.string.price3)
        )
    )
    val items: StateFlow<List<BikeItem>> = _items

    fun increase(itemId: Int) {
        _items.value.find { it.id == itemId }?.count?.update { it + 1 }
    }

    fun decrease(itemId: Int) {
        _items.value.find { it.id == itemId }?.count?.update { current ->
            if (current > 0) current - 1 else current
        }
    }
}
