package com.example.nestednavigation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.nestednavigation.navigation.AuthRouteScreen
import com.example.nestednavigation.navigation.Graph
import com.example.nestednavigation.screens.auth.ForgotPasswordScreen
import com.example.nestednavigation.screens.auth.LoginScreen
import com.example.nestednavigation.screens.auth.RegisterScreen

fun NavGraphBuilder.authNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.AuthGraph,
        startDestination = AuthRouteScreen.Login.route
    ) {
        composable(route = AuthRouteScreen.Login.route) {
            LoginScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.Register.route) {
            RegisterScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.ForgotPassword.route) {
            ForgotPasswordScreen(navController = rootNavController)
        }
    }
}