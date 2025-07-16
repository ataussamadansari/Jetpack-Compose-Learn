package com.example.loginscreenjc.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.loginscreenjc.model.UserData
import com.example.loginscreenjc.ui.theme.GreenJC
import com.example.loginscreenjc.utils.DataStoreManage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(coroutineScope: CoroutineScope, dataStoreManage: DataStoreManage) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val userData by dataStoreManage.userdataFlow.collectAsState(initial = UserData(null, null))

            Text(text = "Welcome ${userData.username}", fontSize = 30.sp, color = GreenJC)

            Button(onClick = {
                coroutineScope.launch {
                    dataStoreManage.clearAllData()
                }
            }) {
                Text("LogOut")
            }
        }
    }
}