package com.example.onlinebikeshoppingapp.thirdScreen

import kotlinx.coroutines.flow.MutableStateFlow

data class BikeItem(
    val id: Int,
    val imageRes: Int,
    val titleRes: Int,
    val price: Double,
    val count: MutableStateFlow<Int> = MutableStateFlow(1)
)
