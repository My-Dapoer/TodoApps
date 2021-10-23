package com.inyongtisto.todoapp.ui.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inyongtisto.myhelper.extension.*
import com.inyongtisto.todoapp.core.data.remote.State
import com.inyongtisto.todoapp.core.data.remote.request.UpdateTodoRequest
import com.inyongtisto.todoapp.core.data.remote.response.TodoResponse
import com.inyongtisto.todoapp.databinding.ActivityEditTodoBinding
import com.inyongtisto.todoapp.ui.adapter.ItemAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditTodoActivity : AppCompatActivity() {

    private val viewModel: TodoViewModel by viewModel()

    private var _binding: ActivityEditTodoBinding? = null
    private val binding get() = _binding!!
    private val adapter = ItemAdapter()
    private lateinit var todo: TodoResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityEditTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()
        getIntentStringExtra()
        setupClickListener()
    }

    private fun getIntentStringExtra() {
        val json = getStringExtra()
        todo = json.toModel(TodoResponse::class.java)!!

        binding.edtName.setText(todo.name)
        adapter.addItem(todo.Items ?: emptyList())
    }

    private fun setupAdapter() {
        binding.rvItems.adapter = adapter
    }

    private fun setupClickListener() {
        binding.apply {
            btnSimpan.setOnClickListener {
                updateTodo()
            }

            btnHapus.setOnClickListener {
                deleteTodo()
            }
        }
    }

    private fun updateTodo() {
        if (binding.edtName.isEmpty()) return

        val body = UpdateTodoRequest(todo.id, binding.edtName.text.toString())
        viewModel.updateTodo(body).observe(this, {
            when (it.state) {
                State.LOADING -> binding.progress.toVisible()
                State.SUCCESS -> {
                    binding.progress.toGone()
                    toastSimple("Update todo success")
                    onBackPressed()
                }
                State.ERROR -> {
                    binding.progress.toGone()
                    toastError(it.message!!)
                    logs("ERROR")
                }
            }
        })
    }

    private fun deleteTodo() {
        viewModel.deleteTodo(todo.id!!).observe(this, {
            when (it.state) {
                State.LOADING -> binding.progress.toVisible()
                State.SUCCESS -> {
                    binding.progress.toGone()
                    toastSimple("Delete todo success")
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