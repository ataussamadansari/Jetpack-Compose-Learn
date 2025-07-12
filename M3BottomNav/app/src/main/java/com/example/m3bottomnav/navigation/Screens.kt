package com.example.m3drawerjc.navigation

sealed class Screens(
    val route: String
) {
    object Home : Screens("home")
    object Profile : Screens("profile")
    object Notification : Screens("notification")
    object Setting : Screens("setting")
}