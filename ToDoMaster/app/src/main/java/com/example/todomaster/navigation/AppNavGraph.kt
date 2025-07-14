package com.example.todomaster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todomaster.screens.AddScreen
import com.example.todomaster.screens.HomeScreen
import com.example.todomaster.screens.LoginScreen
import com.example.todomaster.screens.RegisterScreen
import com.example.todomaster.utils.PrefsHelper
import com.example.todomaster.viewModel.TodoViewModel

@Composable
fun AppNavGraph(viewModel: TodoViewModel, modifier: Modifier = Modifier) {

    val context = LocalContext.current.applicationContext
    val navController = rememberNavController()
    val isLoginIn by remember {
        mutableStateOf(PrefsHelper.getUser(context) != null)
    }

    NavHost(
        navController = navController,
        startDestination = if (isLoginIn) Screens.Home.route else Screens.Login.route
    ) {
        composable(Screens.Login.route) {
            LoginScreen(modifier = modifier)
        }
        composable(Screens.Register.route) {
            RegisterScreen(modifier = modifier)
        }
        composable(Screens.Home.route) {
            HomeScreen(modifier = modifier)
        }
        composable(Screens.Add.route) {
            AddScreen(modifier = modifier)
        }
    }
}