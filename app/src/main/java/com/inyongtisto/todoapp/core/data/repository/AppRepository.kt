package com.inyongtisto.todoapp.core.data.repository

import com.inyongtisto.todoapp.core.data.local.LocalDataSource
import com.inyongtisto.todoapp.core.data.remote.Resource
import com.inyongtisto.todoapp.core.data.remote.model.Todo
import com.inyongtisto.todoapp.core.data.remote.request.TodoRequest
import com.inyongtisto.todoapp.core.data.remote.request.UpdateTodoRequest
import com.inyongtisto.todoapp.core.data.remote.response.RemoteDataSource
import com.inyongtisto.todoapp.core.data.remote.response.base.ListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AppRepository(private val local: LocalDataSource, private val remote: RemoteDataSource) {

    fun getTodo() = flow {
        emit(Resource.loading(null))
        try {
            remote.getTodo().let {
                if (it.isSuccessful) {
                    emit(Resource.success(it.body()!!.data))
                } else {
                    emit(Resource.error(it.body()?.message.toString(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.toString(), null))
        }
    }.flowOn(Dispatchers.IO)


    fun createTodo(data: TodoRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.createTodo(data).let {
                if (it.isSuccessful) {
                    emit(Resource.success(it.body()!!.data))
                } else {
                    emit(Resource.error(it.body()?.message.toString(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.toString(), null))
        }
    }.flowOn(Dispatchers.IO)

    fun updateTodo(data: UpdateTodoRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.updateTodo(data).let {
                if (it.isSuccessful) {
                    emit(Resource.success(it.body()!!.data))
                } else {
                    emit(Resource.error(it.body()?.message.toString(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.toString(), null))
        }
    }.flowOn(Dispatchers.IO)

    fun delete(id: Int) = flow {
        emit(Resource.loading(null))
        try {
            remote.deleteTodo(id).let {
                if (it.isSuccessful) {
                    emit(Resource.success(it.body()!!.data))
                } else {
                    emit(Resource.error(it.body()?.message.toString(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.toString(), null))
        }
    }.flowOn(Dispatchers.IO)
}