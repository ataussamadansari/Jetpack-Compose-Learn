package com.example.todomaster.data.repo

import com.example.todomaster.data.dao.TodoDao
import com.example.todomaster.data.model.Todo

class TodoRepository(private val dao: TodoDao) {
    val allTodos = dao.getAllTodos()

    suspend fun insert(todo: Todo) = dao.insert(todo)
    suspend fun update(todo: Todo) = dao.update(todo)
    suspend fun delete(todo: Todo) = dao.delete(todo)
}
