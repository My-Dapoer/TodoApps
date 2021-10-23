package com.inyongtisto.todoapp.core.data.remote.response

import com.inyongtisto.todoapp.core.data.remote.ApiService
import com.inyongtisto.todoapp.core.data.remote.request.TodoRequest
import com.inyongtisto.todoapp.core.data.remote.request.UpdateTodoRequest

class RemoteDataSource(private val api: ApiService) {

    suspend fun getTodo() = api.getTodo()
    suspend fun createTodo(data: TodoRequest) = api.createTodo(data)
    suspend fun updateTodo(data: UpdateTodoRequest) = api.updateTodo(data.id, data)
    suspend fun deleteTodo(id: Int) = api.deleteTodo(id)
}