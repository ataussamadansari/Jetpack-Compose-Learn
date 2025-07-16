package com.example.datastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.datastore.model.UserData
import com.example.datastore.ui.theme.DataStoreTheme
import com.example.datastore.utils.DataStoreManager
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataStoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val dataStore = DataStoreManager(this)

                    val name by dataStore.nameFlow.collectAsState(initial = "")
                    val isLogin by dataStore.isLoginFlow.collectAsState(initial = false)

                    val userData by dataStore.userDataFlow.collectAsState(
                        initial = UserData(null, null, null, false)
                    )

                    val coroutine = rememberCoroutineScope()

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        TextButton(
                            onClick = {
                                coroutine.launch {
                                    dataStore.saveUserData(
                                        "Aradhya",
                                        "aradhya@gmail.com",
                                        "123456",
                                        true
                                    )
                                }
                            }
                        ) {
                            Text(text = "Add Data")
                        }

                        Text(text = "Name: $name\nLogged In: $isLogin")

                        Text(text = "Name: ${userData.name}")
                        Text(text = "Email: ${userData.email}")
                        Text(text = "Login: ${userData.isLogin}")

                        Button(onClick = {
                            coroutine.launch {
                                dataStore.clearAllData()
                            }
                        }) {
                            Text("LogOut")
                        }
                    }
                }
            }
        }
    }
}