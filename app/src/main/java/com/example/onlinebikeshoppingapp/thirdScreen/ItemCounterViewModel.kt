package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemCounterViewModel : ViewModel() {
    private val _count = MutableStateFlow(1)
    val count: StateFlow<Int> get() = _count

    fun increase() {
        _count.value++
    }

    fun decrease() {
        if (_count.value > 0) _count.value--
    }
}