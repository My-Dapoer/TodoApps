package com.inyongtisto.todoapp.util

import android.app.Application
import com.inyongtisto.todoapp.core.di.appModule
import com.inyongtisto.todoapp.core.di.repositoryModule
import com.inyongtisto.todoapp.core.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewmodelModule, repositoryModule))
        }
    }
}