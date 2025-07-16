package com.example.jetpackcomposeseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeseries.Screens.FlowLayoutScreen
import com.example.jetpackcomposeseries.Screens.StateScreen
import com.example.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme

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
                    FlowLayoutScreen()

                    // without parameter
//                    val mainViewModel by viewModels<MainViewModel>()

                    // with parameter
                    /*val mainViewModel: MainViewModel = viewModel(
                        factory = viewModelFactory {
                            MainViewModel("Samad")
                        }
                    )*/

//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.spacedBy(12.dp)
//                    ) {
//                        /* IncrementScreen(count = mainViewModel.count) {
//                             mainViewModel.inc()
//                         }
//                         DecrementScreen(count = mainViewModel.count) {
//                             mainViewModel.dec()
//                         }*/
//
//                        IncrementScreen(viewModel = mainViewModel)
//                        DecrementScreen(viewModel = mainViewModel)
//                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpackComposeSeriesTheme {
        FlowLayoutScreen()
    }
}

