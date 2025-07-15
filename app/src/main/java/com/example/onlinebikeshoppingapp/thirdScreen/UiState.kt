package com.example.onlinebikeshoppingapp.thirdScreen

data class CartUiState(
    val items: List<BikeItem> = emptyList(),
    val subtotal: Double = 0.0,
    val total: Double = 0.0,
    val isPromoApplied: Boolean = false,
    val appliedCode: String = ""
)
