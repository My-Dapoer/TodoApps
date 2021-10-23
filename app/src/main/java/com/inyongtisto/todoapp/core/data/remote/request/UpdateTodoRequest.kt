package com.inyongtisto.todoapp.core.data.remote.request

import android.os.Parcelable

data class UpdateTodoRequest(
    val id: Int?,
    val name: String?
)