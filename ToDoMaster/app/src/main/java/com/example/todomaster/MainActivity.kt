package com.example.todomaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.todomaster.data.db.TodoDatabase
import com.example.todomaster.data.repo.TodoRepository
import com.example.todomaster.navigation.AppNavGraph
import com.example.todomaster.ui.theme.ToDoMasterTheme
import com.example.todomaster.viewModel.TodoViewModel
import com.example.todomaster.viewModel.TodoViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = TodoDatabase.getDatabase(applicationContext)
        val repo = TodoRepository(db.todoDao())
        val factory = TodoViewModelFactory(repo)
        val viewModel = ViewModelProvider(this, factory)[TodoViewModel::class.java]

        setContent {
            ToDoMasterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavGraph(viewModel = viewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
