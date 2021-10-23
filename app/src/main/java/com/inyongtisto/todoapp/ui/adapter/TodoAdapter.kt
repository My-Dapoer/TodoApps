package com.inyongtisto.todoapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.toJson
import com.inyongtisto.todoapp.core.data.remote.response.TodoResponse
import com.inyongtisto.todoapp.databinding.ItemTodoBinding
import com.inyongtisto.todoapp.ui.todo.EditTodoActivity

@SuppressLint("NotifyDataSetChanged")
class TodoAdapter(var onClick: ((String) -> Unit?)? = null) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    var data = ArrayList<TodoResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }


    fun addItem(item: List<TodoResponse>) {
        data.clear()
        data.addAll(item)
        notifyDataSetChanged()
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val itemBinding: ItemTodoBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            with(itemBinding) {
                val todo = data[position]

                tvName.text = todo.name
                tvItems.text = todo.Items?.size.toString() + " Items"
                lyMain.setOnClickListener {
//                    val intent = Intent(root.context, EditTodoActivity::class.java)
//                    intent.putExtra("todo", "" + todo.toJson())
//                    root.context.startActivity(intent)


                    root.context.intentActivity(EditTodoActivity::class.java, todo.toJson())
                }
            }
        }
    }
}