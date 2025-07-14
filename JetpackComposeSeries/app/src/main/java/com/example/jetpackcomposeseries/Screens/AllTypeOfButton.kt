package com.example.jetpackcomposeseries.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun AllTypeOfButton(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {}
        ) {
            Text(
                text = "Button"
            )
        }

        OutlinedButton(
            onClick = {}
        ) {
            Text(text = "Outlined Button")
        }

        ElevatedButton(onClick = {}) {
            Text(text = "Elevated Button")
        }

        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
        }

        TextButton(onClick = {}) {
            Text(text = "Text Button")
        }

        FilledIconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
        }

        Button(
            onClick = {},
            enabled = false
        ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Button with Icon")
        }

        Button(
            onClick = {},
            shape = RectangleShape
        ) {
            Text("Shape Button")
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Yellow,
                containerColor = Color.DarkGray,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.Red
            )
        ) {
            Text("Button Colors")
        }
        Button(
            onClick = {},
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 20.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text("Button Elevation")
        }

        Button(
            onClick = {},

            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.Red
            ),
            border = ButtonDefaults.outlinedButtonBorder
        ) {
            Text("Outlined Button")
        }

    }

}