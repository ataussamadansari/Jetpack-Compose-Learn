package com.example.nestednavigation.screens.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nestednavigation.navigation.AuthRouteScreen
import com.example.nestednavigation.navigation.Graph
import com.example.nestednavigation.navigation.SettingRouteScreen

@Composable
fun SettingDetailsScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Setting Details Screen",
            fontSize = 40.sp,
            color = Color.Black
        )
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("Go to Settings Screen")
        }

        Button(onClick = {
            navController.navigate(AuthRouteScreen.Login.route) {
                popUpTo(Graph.MainScreenGraph) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }) {
            Text("LogOut")
        }

    }


}