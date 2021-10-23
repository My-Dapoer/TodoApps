package com.inyongtisto.todoapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toVisible
import com.inyongtisto.todoapp.core.data.remote.State
import com.inyongtisto.todoapp.databinding.ActivityMainBinding
import com.inyongtisto.todoapp.ui.adapter.TodoAdapter
import com.inyongtisto.todoapp.ui.todo.CreateTodoActivity
import com.inyongtisto.todoapp.ui.todo.TodoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TodoViewModel by viewModel()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()
        setupClickListener()
    }


    private fun setupClickListener() {
        binding.apply {

            btnAdd.setOnClickListener {
                intentActivity(CreateTodoActivity::class.java)
            }

            btnRefresh.setOnClickListener {
                getTodo()
            }

        }
    }

    private fun getTodo() {
        viewModel.getTodo().observe(this, {
            when (it.state) {
                State.LOADING -> binding.progress.toVisible()
                State.SUCCESS -> {
                    binding.progress.toGone()
                    Log.d("TAG", "getTodo: SUCCESS " + it.body)
                    it.body?.forEach { todo ->
                        Log.d("TAG", "name:" + todo.name)
                    }
                    adapter.addItem(it.body ?: emptyList())
                }
                State.ERROR -> {
                    binding.progress.toGone()
                    Log.d("TAG", "getTodo: ERROR ")
                }
            }
        })
    }

    override fun onResume() {
        getTodo()
        super.onResume()
    }

    private val adapter = TodoAdapter()
    private fun setupAdapter() {
        binding.rvTodo.adapter = adapter
    }
}