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
            is CartEvent.Increase -> Incrase(event.id)

            is CartEvent.Decrease -> Decrase(event.id)

            is CartEvent.CalculateTotal -> CalculateTotal()

            is CartEvent.ApplyCode -> ApplyCode(event.code)
        }
    }

    private fun Incrase(id: Int) {
        val updatedItems = _state.value.items.map { item ->
            if (item.id == id) {
                item.copy(count = item.count + 1)
            } else item
        }
        _state.value = _state.value.copy(items = updatedItems)
    }

    private fun Decrase(id: Int) {
        val updatedItems = _state.value.items.map { item ->
            if (item.id == id) {
                item.copy(count = if (item.count > 0) item.count - 1 else 0)
            } else item
        }
        _state.value = _state.value.copy(items = updatedItems)
    }

    private fun CalculateTotal() {
        val subtotal = _state.value.items.sumOf { it.price * it.count }
        val total = subtotal
        _state.value = _state.value.copy(subtotal = subtotal, total = total)
    }

    private fun ApplyCode(code: String) {}


}
