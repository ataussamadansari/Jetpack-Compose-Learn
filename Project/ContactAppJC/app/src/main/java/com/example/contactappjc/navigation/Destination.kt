package com.example.contactappjc.navigation

sealed class Destination(val route: String) {
    data object Home : Destination("home")
    data object Add : Destination("add")

    data object Edit : Destination("contactEdit/{contactId}") {
        fun createRoute(contactId: Int) = "contactEdit/$contactId"
    }
    data object Detail : Destination("contactDetail/{contactId}") {
        fun createRoute(contactId: Int) = "contactDetail/$contactId"
    }

}
