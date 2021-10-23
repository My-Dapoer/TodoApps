package com.inyongtisto.todoapp.ui.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inyongtisto.todoapp.core.data.remote.request.TodoRequest
import com.inyongtisto.todoapp.core.data.remote.request.UpdateTodoRequest
import com.inyongtisto.todoapp.core.data.repository.AppRepository

class TodoViewModel(private val repo: AppRepository) : ViewModel() {

    fun getTodo() = repo.getTodo().asLiveData()

    fun createTodo(data: TodoRequest) = repo.createTodo(data).asLiveData()

    fun updateTodo(data: UpdateTodoRequest) = repo.updateTodo(data).asLiveData()

    fun deleteTodo(id: Int) = repo.delete(id).asLiveData()

}