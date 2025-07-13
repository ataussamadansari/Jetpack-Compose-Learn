package com.example.nestednavigation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.nestednavigation.navigation.AuthRouteScreen
import com.example.nestednavigation.navigation.Graph

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                navController.navigate(Graph.MainScreenGraph) {
                    popUpTo(AuthRouteScreen.Register.route) {
                        inclusive = true
                    }
                }
            }
        ) {
            Text(text = "Register")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already have an account?")
            TextButton(onClick = {
                navController.navigateUp()
            }) {
                Text(text = "Login")
            }
        }
    }
}