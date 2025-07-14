package com.example.todomaster.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.todomaster.data.model.Todo
import com.example.todomaster.data.repo.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    val allTodos = repository.allTodos.asLiveData()

    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }

    fun update(todo: Todo) = viewModelScope.launch {
        repository.update(todo)
    }

    fun delete(todo: Todo) = viewModelScope.launch {
        repository.delete(todo)
    }
}
