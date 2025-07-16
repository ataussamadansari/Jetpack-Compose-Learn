package com.example.navcomponent

sealed class Destinations(val route: String) {
    data object MainScreen: Destinations("main")
    data object HomeScreen: Destinations("home")
}