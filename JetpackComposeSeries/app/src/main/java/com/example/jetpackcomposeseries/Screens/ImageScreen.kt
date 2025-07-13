package com.example.jetpackcomposeseries.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeseries.R

@Composable
fun ImageScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.avtar8),
            contentDescription = "image",
            modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .background(Color.Yellow)
                .border(2.dp, Color.Green, shape = RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Fit,
        )

        Icon(
            imageVector = Icons.Default.Settings, contentDescription = "icon", tint = Color.Cyan
        )
    }
}