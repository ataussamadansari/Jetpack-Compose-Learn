package com.example.m3bottomnav.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.m3bottomnav.screens.HomeScreen
import com.example.m3bottomnav.screens.NotificationScreen
import com.example.m3bottomnav.screens.ProfileScreen
import com.example.m3bottomnav.screens.SettingScreen

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