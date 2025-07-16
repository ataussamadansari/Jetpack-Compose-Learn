package com.example.contactappjc.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.contactappjc.screens.AddContactScreen
import com.example.contactappjc.screens.ContactDetailScreen
import com.example.contactappjc.screens.ContactListScreen
import com.example.contactappjc.screens.EditContactScreen
import com.example.contactappjc.viewmodel.ContactViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: ContactViewModel) {

    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(Destination.Home.route) {
            ContactListScreen(viewModel = viewModel, navController = navController)
        }
        composable(Destination.Add.route) {
            AddContactScreen(viewModel = viewModel, navController = navController)
        }
        composable(
            route = Destination.Detail.route,
            arguments = listOf(navArgument("contactId") { type = NavType.IntType })
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getInt("contactId")
            val contact = viewModel.allContacts.observeAsState(initial = emptyList()).value.find {
                it.id == contactId
            }
            contact?.let {
                ContactDetailScreen(contact = it, viewModel = viewModel, navController = navController)
            }
        }
        composable(
            route = Destination.Edit.route,
            arguments = listOf(navArgument("contactId") { type = NavType.IntType })
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getInt("contactId")
            val contact = viewModel.allContacts.observeAsState(initial = emptyList()).value.find {
                it.id == contactId
            }
            contact?.let {
                EditContactScreen(contact = it, viewModel = viewModel, navController = navController)
            }
        }
    }
}