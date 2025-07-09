package com.example.navdrawerjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navdrawerjc.nav.Screens
import com.example.navdrawerjc.ui.screens.Home
import com.example.navdrawerjc.ui.screens.Profile
import com.example.navdrawerjc.ui.screens.Settings
import com.example.navdrawerjc.ui.theme.Green
import com.example.navdrawerjc.ui.theme.NavDrawerJCTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavDrawerJCTheme {
                Surface() {
                    LearnNavDrawer()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavDrawer(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState, gesturesEnabled = true, drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(Green)
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Text(text = "")
                }
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home", color = Green) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home",
                            tint = Green
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Home.screen) {
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Profile", color = Green) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = Green
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Profile.screen) {
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Settings", color = Green) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = Green
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Settings.screen) {
                            popUpTo(0)
                        }
                    })
            }
        }) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = { Text(text = "WhatsApp") }, colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Green,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ), navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                        }
                    })
            },
        ) { paddingValues ->
            NavHost(
                navController = navController, startDestination = Screens.Home.screen
            ) {
                composable(Screens.Home.screen) { Home(modifier = Modifier.padding(paddingValues)) }
                composable(Screens.Profile.screen) { Profile(modifier = Modifier.padding(paddingValues)) }
                composable(Screens.Settings.screen) { Settings(modifier = Modifier.padding(paddingValues)) }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    NavDrawerJCTheme {
        LearnNavDrawer()
    }
}