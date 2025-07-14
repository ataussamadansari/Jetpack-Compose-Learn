package com.example.counterapp.viewModel

import androidx.lifecycle.ViewModel


class CounterViewModel(private val startCount: Int) : ViewModel() {

    var count = startCount
        private set

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }
}