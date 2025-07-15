package com.example.loginscreenjc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.loginscreenjc.screens.HomeScreen
import com.example.loginscreenjc.screens.LoginScreen
import com.example.loginscreenjc.utils.DataStoreManage
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    coroutineScope: CoroutineScope,
    dataStoreManage: DataStoreManage
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("login") {
            LoginScreen(
                coroutineScope, dataStoreManage,
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo(0)
                    }
                })
        }
        composable("home") {
            HomeScreen(coroutineScope, dataStoreManage)
        }
    }
}