package com.example.todomaster.navigation

sealed class Screens(val route: String) {
    data object Login: Screens("login")
    data object Register: Screens("register")
    data object Home: Screens("home")
    data object Add: Screens("add")
}