package com.inyongtisto.todoapp.core.data.remote.response.base

import android.os.Parcelable

data class ListResponse<T>(
    val message: String? = null,
    val data: List<T>? = null
)