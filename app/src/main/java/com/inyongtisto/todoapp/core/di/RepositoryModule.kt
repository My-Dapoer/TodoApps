package com.inyongtisto.todoapp.core.di

import com.inyongtisto.todoapp.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
}
