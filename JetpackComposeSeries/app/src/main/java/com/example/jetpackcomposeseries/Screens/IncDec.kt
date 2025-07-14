package com.example.jetpackcomposeseries.Screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcomposeseries.viewModel.MainViewModel

@Composable
//fun IncrementScreen(modifier: Modifier = Modifier, count: Int, onClick: () -> Unit) {
fun IncrementScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    Button(onClick = {
//        onClick()
        viewModel.inc()
    }) {
        Text(text = "${viewModel.count} Increment")
    }

}

@Composable
//fun DecrementScreen(modifier: Modifier = Modifier, count: Int, onClick: () -> Unit) {
fun DecrementScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {

    Button(onClick = {
//        onClick()
        viewModel.dec()
    }) {
        Text(text = "${viewModel.count} Decrement")
    }
}

