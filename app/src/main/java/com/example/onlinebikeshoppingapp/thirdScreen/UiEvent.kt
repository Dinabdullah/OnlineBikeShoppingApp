package com.example.onlinebikeshoppingapp.thirdScreen

sealed class CartEvent {
    data class Increase(val id: Int) : CartEvent()
    data class Decrease(val id: Int) : CartEvent()
    data class ApplyCode(val code: String) : CartEvent()
}
