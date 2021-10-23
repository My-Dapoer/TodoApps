package com.inyongtisto.todoapp.core.data.remote.model

import android.os.Parcelable

data class Todo(
    val Items: List<Item>?,
    val id: Int?,
    val name: String?
)