package com.example.jetpackcomposeseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.jetpackcomposeseries.Screens.AllTypeOfButton
import com.example.jetpackcomposeseries.Screens.BoxScreen
import com.example.jetpackcomposeseries.Screens.DecrementScreen
import com.example.jetpackcomposeseries.Screens.ImageScreen
import com.example.jetpackcomposeseries.Screens.IncrementScreen
import com.example.jetpackcomposeseries.Screens.StateScreen
import com.example.jetpackcomposeseries.Screens.TextFieldScreen
import com.example.jetpackcomposeseries.Screens.TextScreen
import com.example.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme
import com.example.jetpackcomposeseries.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val mainViewModel = MainViewModel()
            JetpackComposeSeriesTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextFieldScreen(modifier = Modifier.padding(innerPadding))
                }*/
                /*var count by rememberSaveable {
                    mutableStateOf(0)
                }*/
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // without parameter
//                    val mainViewModel by viewModels<MainViewModel>()

                    // with parameter
                    val mainViewModel : MainViewModel = viewModel(
                        factory = viewModelFactory {
                            MainViewModel("Samad")
                        }
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                       /* IncrementScreen(count = mainViewModel.count) {
                            mainViewModel.inc()
                        }
                        DecrementScreen(count = mainViewModel.count) {
                            mainViewModel.dec()
                        }*/

                        IncrementScreen(viewModel = mainViewModel)
                        DecrementScreen(viewModel = mainViewModel)                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpackComposeSeriesTheme {
        StateScreen()
    }
}

