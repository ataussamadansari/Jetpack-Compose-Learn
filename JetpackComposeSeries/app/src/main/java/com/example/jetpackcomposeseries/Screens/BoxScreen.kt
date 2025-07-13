package com.example.jetpackcomposeseries.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BoxScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "Hello World!", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "Hello World!", modifier = Modifier.align(Alignment.Center))
        Text(text = "Hello World!", modifier = Modifier.align(Alignment.BottomCenter))
    }
}