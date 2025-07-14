package com.example.jetpackcomposeseries.Screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun StateScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        var count by remember {
        var count by rememberSaveable {
            mutableStateOf(0)
        }
        Log.d("TAG", "initial composition")
        Text(text = "$count")
        Button(onClick = {
            count++
            Log.d("TAG", count.toString())
        }) {
            Log.d("TAG", "re-composition")
            Text(text = "Increment")
        }

    }
}