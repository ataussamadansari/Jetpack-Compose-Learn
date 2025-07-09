package com.example.layoutjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutjc.ui.theme.LayoutJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutJCTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { paddingValues ->
                    LearnLayouts(Modifier.padding(paddingValues))
                }
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnLayouts()
                }*/
            }
        }
    }
}

@Composable
fun LearnLayouts(modifier: Modifier = Modifier) {
    /*No any layout*/
    /*Text(text = "Hello Row!")
    Text(text = "Hello Column!")
    Text(text = "Hello Box!")*/

    /*Column Layout*/
    /*Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello Column 1")
        Text(text = "Hello Column 2")
        Text(text = "Hello Column 3")
    }*/

    /*Row Layout*/
    /* Row(
         modifier = modifier,
         horizontalArrangement = Arrangement.Center,
         verticalAlignment = Alignment.CenterVertically
     ) {
         Text(text = "Hello Row 1")
         Text(text = "Hello Row 2")
         Text(text = "Hello Row 3")
     }*/

    /*Box Layout*/
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .background(Color.Blue)
        ) {
            Text(
                "Hello Box",
                modifier = Modifier
                    .align(Alignment.Center),
                color = Color.White,
                fontSize = 32.sp
            )
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewLearnLayout() {
    LearnLayouts()
}
