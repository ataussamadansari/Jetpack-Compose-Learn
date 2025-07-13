package com.example.nestednavigation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.nestednavigation.navigation.Graph
import com.example.nestednavigation.navigation.NotificationRouteScreen
import com.example.nestednavigation.navigation.SettingRouteScreen
import com.example.nestednavigation.screens.setting.SettingDetailsScreen


fun NavGraphBuilder.settingNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.SettingGraph,
        startDestination = SettingRouteScreen.SettingDetail.route
    ) {
        composable(route = SettingRouteScreen.SettingDetail.route) {
            SettingDetailsScreen(navController = rootNavController)
        }
    }
}