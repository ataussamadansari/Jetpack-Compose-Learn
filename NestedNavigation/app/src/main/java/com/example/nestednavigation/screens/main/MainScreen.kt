package com.example.nestednavigation.screens.main

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nestednavigation.navigation.BottomNavigationBar
import com.example.nestednavigation.navigation.MainRouteScreen
import com.example.nestednavigation.navigation.graphs.MainNavGraph
import com.example.nestednavigation.utils.bottomNavigationItemsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    homeNavController: NavHostController = rememberNavController(),
    rootNavController: NavHostController
) {
    val context = LocalContext.current.applicationContext
    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route
        }
    }
    val topBarTitle by remember(currentRoute) {
        derivedStateOf {
            if (currentRoute != null) {
                bottomNavigationItemsList[bottomNavigationItemsList.indexOfFirst {
                    it.route == currentRoute
                }].title
            } else {
                bottomNavigationItemsList[0].title
            }
        }
    }
    Scaffold(
        topBar = {

            if (currentRoute == MainRouteScreen.Home.route || currentRoute == MainRouteScreen.Profile.route || currentRoute == MainRouteScreen.Notification.route) {
                TopAppBar(title = {
                    Text(text = topBarTitle)
                }, actions = {
                    when(currentRoute) {
                        MainRouteScreen.Home.route -> {
                            IconButton(
                                onClick = {
                                    Toast.makeText(context, "Home Clicked", Toast.LENGTH_SHORT).show()
                                }
                            ) {
                                Icon(imageVector = Icons.Default.MoreVert,  contentDescription = "Action Menu")
                            }
                        }
                        MainRouteScreen.Profile.route -> {
                            IconButton(
                                onClick = {
                                    Toast.makeText(context, "Profile Clicked", Toast.LENGTH_SHORT).show()
                                }
                            ) {
                                Icon(imageVector = Icons.Default.MoreVert,  contentDescription = "Action Menu")
                            }
                        }
                    }
                })
            }
        },
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavigationItemsList,
                currentRoute = currentRoute
            ) { currentNavigationItem ->
                homeNavController.navigate(currentNavigationItem.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    homeNavController.graph.startDestinationRoute?.let { startDestinationRoute ->
                        // Pop up to the start destination, clearing the back stack
                        popUpTo(startDestinationRoute) {
                            // Save the state of popped destinations
                            saveState = true
                        }
                    }

                    // Configure navigation to avoid multiple instances of the same destination
                    launchSingleTop = true

                    // Restore state when re-selecting a previously selected item
                    restoreState = true
                }
            }
        }
    ) { innerPadding ->
        MainNavGraph(
            homeNavController = homeNavController,
            rootNavController = rootNavController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}