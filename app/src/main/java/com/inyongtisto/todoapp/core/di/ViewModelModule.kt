package com.inyongtisto.todoapp.core.di

import com.inyongtisto.todoapp.ui.todo.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { TodoViewModel(get()) }
}
