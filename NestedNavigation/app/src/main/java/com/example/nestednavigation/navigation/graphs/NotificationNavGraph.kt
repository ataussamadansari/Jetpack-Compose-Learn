package com.example.nestednavigation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.nestednavigation.navigation.Graph
import com.example.nestednavigation.navigation.NotificationRouteScreen
import com.example.nestednavigation.screens.notification.NotificationDetailsScreen

fun NavGraphBuilder.notificationNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.NotificationGraph,
        startDestination = NotificationRouteScreen.NotificationDetail.route
    ) {
        composable(route = NotificationRouteScreen.NotificationDetail.route) {
            NotificationDetailsScreen(navController = rootNavController)
        }
    }
}