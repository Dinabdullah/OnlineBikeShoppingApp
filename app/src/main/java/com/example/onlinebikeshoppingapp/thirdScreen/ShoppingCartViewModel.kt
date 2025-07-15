package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.lifecycle.ViewModel
import com.example.onlinebikeshoppingapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ShoppingCartViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        CartUiState(
            items = listOf(
                BikeItem(1, R.drawable.bike1, R.string.title1, 10.0),
                BikeItem(2, R.drawable.bike2, R.string.title2, 20.0),
                BikeItem(3, R.drawable.bike3, R.string.title3, 30.0)
            )
        )
    )
    val state: StateFlow<CartUiState> = _state

    fun onEvent(event: CartEvent) {
        when (event) {
            is CartEvent.Increase -> {
                val updatedItems = _state.value.items.map { item ->
                    if (item.id == event.id) {
                        item.copy(count = item.count + 1)
                    } else item
                }
                _state.value = _state.value.copy(items = updatedItems)
            }

            is CartEvent.Decrease -> {
                val updatedItems = _state.value.items.map { item ->
                    if (item.id == event.id) {
                        item.copy(count = if (item.count > 0) item.count - 1 else 0)
                    } else item
                }
                _state.value = _state.value.copy(items = updatedItems)
            }

            is CartEvent.ApplyCode -> {
                val subtotal = _state.value.items.sumOf { it.price * it.count }
                val total = subtotal * 0.7
                // val total = subtotal * 0.7  for any Discount
                _state.value = _state.value.copy(
                    appliedCode = event.code,
                    isPromoApplied = true,
                    subtotal = subtotal,
                    total = total
                )
            }
        }
    }

}
