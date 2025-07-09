package com.example.textandmodifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.textandmodifiers.ui.theme.TextAndModifiresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextAndModifiresTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    LearnTextAndModifier()
                }
            }
        }
    }
}


@Composable
fun LearnTextAndModifier() {
    val clickOnText = {}
    Text(
        text = stringResource(R.string.hello_text),         //or "Hello World!",
        color = Color.Red,
        fontStyle = FontStyle.Italic,
        fontSize = 30.sp,
        modifier = Modifier
            .padding(12.dp)
            .background(Color.Green)
            .clickable(onClick = clickOnText)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewTextAndModifiers() {
    LearnTextAndModifier()
}