package com.inyongtisto.todoapp.core.di

import com.inyongtisto.todoapp.core.data.local.LocalDataSource
import com.inyongtisto.todoapp.core.data.remote.ApiConfig
import com.inyongtisto.todoapp.core.data.remote.response.RemoteDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

    single { ApiConfig.provideApiService }

    single { LocalDataSource() }

    single { RemoteDataSource(get()) }
}