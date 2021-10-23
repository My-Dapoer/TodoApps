package com.inyongtisto.todoapp.core.data.remote.response

import android.os.Parcelable

data class TodoResponse(
    val Items: List<ItemResponse>?,
    val id: Int?,
    val name: String?
)