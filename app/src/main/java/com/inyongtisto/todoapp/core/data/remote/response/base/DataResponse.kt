package com.inyongtisto.todoapp.core.data.remote.response.base

import android.os.Parcelable

data class DataResponse<T>(
    val message: String? = null,
    val data: T? = null
)