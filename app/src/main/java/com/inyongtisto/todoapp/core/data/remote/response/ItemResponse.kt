package com.inyongtisto.todoapp.core.data.remote.response


import android.os.Parcelable

data class ItemResponse(
    val id: Int?,
    val name: String?,
    val status: Boolean?
)