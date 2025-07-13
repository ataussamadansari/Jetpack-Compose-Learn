package com.example.nestednavigation.navigation

object Graph {
    const val RootGraph = "rootGraph"
    const val AuthGraph = "authGraph"
    const val MainScreenGraph = "mainScreenGraph"
    const val NotificationGraph = "notificationGraph"
    const val SettingGraph = "settingGraph"
}

sealed class AuthRouteScreen(val route: String) {
    object Login : AuthRouteScreen("login")
    object Register : AuthRouteScreen("register")
    object ForgotPassword : AuthRouteScreen("forgotPassword")
}

sealed class MainRouteScreen(val route: String) {
    object Home : MainRouteScreen("home")
    object Profile : MainRouteScreen("profile")
    object Notification : MainRouteScreen("notification")
    object Setting : MainRouteScreen("setting")
}

sealed class NotificationRouteScreen(val route: String) {
    object NotificationDetail : NotificationRouteScreen("notificationDetail")
}

sealed class SettingRouteScreen(val route: String) {
    object SettingDetail : SettingRouteScreen("settingDetail")
}