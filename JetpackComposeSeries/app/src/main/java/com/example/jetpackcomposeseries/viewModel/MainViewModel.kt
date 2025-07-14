package com.example.jetpackcomposeseries.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

//class MainViewModel() : ViewModel() {
class MainViewModel(name: String) : ViewModel() {
    var count by mutableStateOf(0)
        private set

    fun inc() {
        count++
    }

    fun dec() {
        count--
    }
}