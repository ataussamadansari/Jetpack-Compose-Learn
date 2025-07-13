package com.example.nestednavigation.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nestednavigation.navigation.Graph
import com.example.nestednavigation.screens.main.MainScreen

@Composable
fun RootNavGraph(isAuth: Boolean) {
    val rootNavController = rememberNavController()
    NavHost(
        navController = rootNavController,
        route = Graph.RootGraph,
        startDestination = if (isAuth) Graph.MainScreenGraph else Graph.AuthGraph
    ) {
        authNavGraph(rootNavController = rootNavController)
        composable(route = Graph.MainScreenGraph) {
            MainScreen(rootNavController = rootNavController)
        }
        notificationNavGraph(rootNavController = rootNavController)
        settingNavGraph(rootNavController = rootNavController)
    }
}

