package com.inyongtisto.todoapp.core.data.remote

import com.inyongtisto.todoapp.core.data.remote.request.TodoRequest
import com.inyongtisto.todoapp.core.data.remote.request.UpdateTodoRequest
import com.inyongtisto.todoapp.core.data.remote.response.ItemResponse
import com.inyongtisto.todoapp.core.data.remote.response.TodoResponse
import com.inyongtisto.todoapp.core.data.remote.response.base.DataResponse
import com.inyongtisto.todoapp.core.data.remote.response.base.ListResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("todos")
    suspend fun getTodo(): Response<ListResponse<TodoResponse>>

    @POST("todos")
    suspend fun createTodo(
        @Body data: TodoRequest
    ): Response<DataResponse<TodoResponse>>

    @PUT("todos/{id}")
    suspend fun updateTodo(
        @Path("id") id: Int?,
        @Body data: UpdateTodoRequest
    ): Response<DataResponse<TodoResponse>>

    @DELETE("todos/{id}")
    suspend fun deleteTodo(
        @Path("id") id: Int?,
    ): Response<DataResponse<TodoResponse>>

    @GET("items")
    suspend fun getItems(
        @Body bank: TodoRequest
    ): Response<DataResponse<ItemResponse>>
}