package com.example.statejc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.statejc.ui.theme.StateJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateJCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LearnState(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LearnState(modifier: Modifier = Modifier) {
//    var age = 0
    var age by remember {
        mutableStateOf(0)
    }

    Button(
        modifier = modifier,
        onClick = {
            age++
            Log.d("TAG", "age: $age")
        }
    ) {
        Text(text = "I'm $age years old.")
    }
}
