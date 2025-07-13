package com.example.jetpackcomposeseries.Screens

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeseries.R

@Composable
fun TextScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello World!")
        Text(text = stringResource(R.string.app_name))
        Text(
            text = "Font Color Size Weight",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta
        )
        Text(text = "Font Style", fontStyle = FontStyle.Italic)
        Text(text = "Font Family", fontFamily = FontFamily.Monospace)
        Text(
            text = "Font Family Custom",
            fontFamily = FontFamily(Font(R.font.caveat_regular)),
            fontSize = 22.sp
        )
        Text(
            text = "Gradient Font", style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Magenta, Color.Green)
                ),
                fontSize = 30.sp
            )
        )
        val offset = Offset(5.0f, 10.0f)
        Text(
            text = "Font Style",
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray, offset = offset, blurRadius = 3f
                )
            )
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("H")
                }
                append("ello ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append("W")
                }
                append("orld")
            }
        )

        Text(
            "Learn about why it's great to use Jetpack Compose",
            modifier = Modifier.basicMarquee(),
            fontSize = 50.sp
        )
    }
}