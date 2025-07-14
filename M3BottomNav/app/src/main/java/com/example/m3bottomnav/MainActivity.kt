package com.example.m3bottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.m3bottomnav.navigation.AppNavGraph
import com.example.m3bottomnav.navigation.BottomNavigationBar
import com.example.m3bottomnav.navigation.NavigationItem
import com.example.m3bottomnav.navigation.Screens
import com.example.m3bottomnav.ui.theme.M3BottomNavTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M3BottomNavTheme {

                val items = listOf(
                    NavigationItem(
                        title = "Home",
                        route = Screens.Home.route,
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        false
                    ),
                    NavigationItem(
                        title = "Profile",
                        route = Screens.Profile.route,
                        selectedIcon = Icons.Filled.Person,
                        unselectedIcon = Icons.Outlined.Person,
                        false
                    ),
                    NavigationItem(
                        title = "Notifications",
                        route = Screens.Notification.route,
                        selectedIcon = Icons.Filled.Notifications,
                        unselectedIcon = Icons.Outlined.Notifications,
                        false,
                        badgeCount = 9,
                    ),
                    NavigationItem(
                        title = "Settings",
                        route = Screens.Setting.route,
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings,
                        true
                    )
                )

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val topbarTitle =
                    if (currentRoute != null) {
                        items[items.indexOfFirst {
                            it.route == currentRoute
                        }].title
                    } else {
                        items[0].title
                    }


                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = topbarTitle)
                            }
                        )
                    },

                    bottomBar = {
                        BottomNavigationBar(
                            items = items, currentRoute = currentRoute
                        ) { currentNavItem ->
                            navController.navigate(currentNavItem.route) {
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    AppNavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

