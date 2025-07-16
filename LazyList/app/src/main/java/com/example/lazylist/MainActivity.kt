package com.example.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.lazylist.ui.theme.LazyListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val fruitsList = listOf(
                        "Papaya", "Watermelon", "Banana", "Mango",
                        "Papaya", "Watermelon", "Banana", "Mango",
                        "Papaya", "Watermelon", "Banana", "Mango",
                        "Papaya", "Watermelon", "Banana", "Mango",
                        "Papaya", "Watermelon", "Banana", "Mango",
                        "Papaya", "Watermelon", "Banana", "Mango",
                        "Papaya", "Watermelon", "Banana", "Mango",
                    )
                    ListExample(modifier = Modifier.padding(innerPadding), fruitsList = fruitsList)
                }
            }
        }
    }
}

@Composable
fun ListExample(modifier: Modifier = Modifier, fruitsList: List<String>) {
    /*Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        fruitsList.forEach {
            Text(text = "$it", fontSize = 30.sp, color = Color.DarkGray)
            Divider()
        }
    }*/

    LazyColumn(modifier = modifier) {

        item {
            LazyRow {
                items(fruitsList) {
                    Text(text = " $it", fontSize = 30.sp, color = Color.Red)
                }
            }
        }
        items(fruitsList) {
            Text(text = "$it", fontSize = 30.sp, color = Color.DarkGray)
            Divider()
        }

    }
}