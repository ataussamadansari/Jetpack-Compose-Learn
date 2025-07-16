package com.example.contactappjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.contactappjc.database.ContactDB
import com.example.contactappjc.navigation.NavGraph
import com.example.contactappjc.repositories.ContactRepository
import com.example.contactappjc.ui.theme.ContactAppJCTheme
import com.example.contactappjc.viewmodel.ContactViewModel
import com.example.contactappjc.viewmodel.ContactViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database =
            Room.databaseBuilder(applicationContext, ContactDB::class.java, "contact_db").build()
        val repository = ContactRepository(database.contactDao())
        val viewModel: ContactViewModel by viewModels { ContactViewModelFactory(repository) }

        setContent {
            ContactAppJCTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}

