package com.example.onlinebikeshoppingapp.thirdScreen

data class BikeItem(
    val id: Int,
    val imageRes: Int,
    val titleRes: Int,
    val price: Double,
    val count: Int = 1
)

