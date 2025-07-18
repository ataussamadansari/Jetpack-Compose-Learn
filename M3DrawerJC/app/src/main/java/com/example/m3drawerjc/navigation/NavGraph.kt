package com.example.m3drawerjc.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.m3drawerjc.screens.HomeScreen
import com.example.m3drawerjc.screens.NotificationScreen
import com.example.m3drawerjc.screens.ProfileScreen
import com.example.m3drawerjc.screens.SettingScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            HomeScreen(modifier = modifier)
        }
        composable(Screens.Profile.route) {
            ProfileScreen(modifier = modifier)
        }
        composable(Screens.Notification.route) {
            NotificationScreen(modifier = modifier)
        }
        composable(Screens.Setting.route) {
            SettingScreen(modifier = modifier)
        }
    }
}