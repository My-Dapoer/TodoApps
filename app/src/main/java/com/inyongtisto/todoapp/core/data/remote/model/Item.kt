package com.inyongtisto.todoapp.core.data.remote.model


import android.os.Parcelable

data class Item(
    val id: Int?,
    val name: String?,
    val status: Boolean?
)