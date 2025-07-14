package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.counterapp.ui.theme.CounterAppTheme
import com.example.counterapp.viewModel.CounterViewModel
import com.example.counterapp.viewModel.CounterViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // ViewModelFactory instance
        val factory = CounterViewModelFactory(startCount = 10)

        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel: CounterViewModel = ViewModelProvider(this, factory)[CounterViewModel::class.java]
                    CounterScreen(modifier = Modifier.padding(innerPadding), viewModel)
                }
            }
        }
    }
}


@Composable
fun CounterScreen(modifier: Modifier  = Modifier, viewModel: CounterViewModel) {
    var count by remember { mutableStateOf(viewModel.count) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Count: $count", style = MaterialTheme.typography.headlineMedium)

        Row {
            Button(onClick = {
                viewModel.increment()
                count = viewModel.count
            }, modifier = Modifier.padding(8.dp)) {
                Text("Increment")
            }

            Button(onClick = {
                viewModel.decrement()
                count = viewModel.count
            }, modifier = Modifier.padding(8.dp)) {
                Text("Decrement")
            }
        }
    }
}