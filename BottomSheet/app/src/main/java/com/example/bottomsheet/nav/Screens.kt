package com.example.bottomsheet.nav

sealed class Screens(val screen: String){
    data object Home: Screens("home")
    data object Search: Screens("search")
    data object Notifications: Screens("notifications")
    data object Profile: Screens("profile")
    data object Post: Screens("post")
}