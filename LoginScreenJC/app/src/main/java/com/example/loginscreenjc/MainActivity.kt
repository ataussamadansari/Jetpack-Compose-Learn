package com.example.loginscreenjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.loginscreenjc.navigation.NavGraph
import com.example.loginscreenjc.ui.theme.LoginScreenJCTheme
import com.example.loginscreenjc.utils.DataStoreManage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            LoginScreenJCTheme {
                val coroutineScope = rememberCoroutineScope()
                val dataStoreManager = DataStoreManage(this)
                val navController = rememberNavController()

                val isLoginFlow = dataStoreManager.isLoginFlow
                var isLoginReady by remember { mutableStateOf(false) }
                var isLoggedIn by remember { mutableStateOf(false) }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .paint(
                            painter = painterResource(R.drawable.pagebkg),
                            contentScale = ContentScale.FillBounds
                        ),
                ) {

                    // 🔁 Wait for DataStore value before launching NavGraph
                    LaunchedEffect(Unit) {
                        isLoginFlow.collect {
                            isLoggedIn = it
                            isLoginReady = true
                        }
                    }

                    if (isLoginReady) {
                        NavGraph(
                            navController = navController,
                            startDestination = if (isLoggedIn) "home" else "login",
                            coroutineScope = coroutineScope,
                            dataStoreManage = dataStoreManager
                        )
                    }
                }
            }
        }
    }
}
