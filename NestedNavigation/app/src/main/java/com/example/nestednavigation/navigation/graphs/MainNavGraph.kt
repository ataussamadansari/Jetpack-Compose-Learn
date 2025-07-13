package com.example.nestednavigation.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nestednavigation.navigation.Graph
import com.example.nestednavigation.navigation.MainRouteScreen
import com.example.nestednavigation.screens.main.HomeScreen
import com.example.nestednavigation.screens.main.NotificationsScreen
import com.example.nestednavigation.screens.main.ProfileScreen
import com.example.nestednavigation.screens.main.SettingsScreen

@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = homeNavController,
        route = Graph.MainScreenGraph,
        startDestination = MainRouteScreen.Home.route
    ) {
        composable(route = MainRouteScreen.Home.route) {
            HomeScreen(modifier = modifier, navController = rootNavController)
        }
        composable(route = MainRouteScreen.Profile.route) {
            ProfileScreen(modifier = modifier, navController = rootNavController)
        }
        composable(route = MainRouteScreen.Notification.route) {
            NotificationsScreen(modifier = modifier, navController = rootNavController)
        }
        composable(route = MainRouteScreen.Setting.route) {
            SettingsScreen(modifier = modifier, navController = rootNavController)
        }
    }
}