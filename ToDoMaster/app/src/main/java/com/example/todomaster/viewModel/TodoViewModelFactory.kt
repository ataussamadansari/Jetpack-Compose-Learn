package com.example.todomaster.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todomaster.data.repo.TodoRepository

class TodoViewModelFactory(private val repo: TodoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoViewModel(repo) as T
    }
}
