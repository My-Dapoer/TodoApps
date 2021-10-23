package com.inyongtisto.todoapp.ui.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inyongtisto.myhelper.extension.*
import com.inyongtisto.todoapp.core.data.remote.State
import com.inyongtisto.todoapp.core.data.remote.request.TodoRequest
import com.inyongtisto.todoapp.databinding.ActivityCreateTodoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateTodoActivity : AppCompatActivity() {

    private val viewModel: TodoViewModel by viewModel()

    private var _binding: ActivityCreateTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCreateTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListener()
    }


    private fun setupClickListener() {

        binding.apply {
            btnAdd.setOnClickListener {
                createTodo()
            }

        }
    }

    private fun createTodo() {
        if (binding.edtName.isEmpty()) return

        val body = TodoRequest(binding.edtName.text.toString())
        viewModel.createTodo(body).observe(this, {
            when (it.state) {
                State.LOADING -> binding.progress.toVisible()
                State.SUCCESS -> {
                    binding.progress.toGone()
                    toastSimple("Create todo success")
                    onBackPressed()
                }
                State.ERROR -> {
                    binding.progress.toGone()
                    toastError(it.message!!)
                    Log.d("TAG", "getTodo: ERROR ")
                }
            }
        })
    }
}