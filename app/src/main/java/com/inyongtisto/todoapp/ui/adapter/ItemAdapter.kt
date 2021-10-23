package com.inyongtisto.todoapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.todoapp.core.data.remote.response.ItemResponse
import com.inyongtisto.todoapp.core.data.remote.response.TodoResponse
import com.inyongtisto.todoapp.databinding.ItemItemsBinding
import com.inyongtisto.todoapp.databinding.ItemTodoBinding

@SuppressLint("NotifyDataSetChanged")
class ItemAdapter(var onClick: ((String) -> Unit?)? = null) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var data = ArrayList<ItemResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }


    fun addItem(item: List<ItemResponse>) {
        data.clear()
        data.addAll(item)
        notifyDataSetChanged()
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val itemBinding: ItemItemsBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            with(itemBinding) {
                val todo = data[position]
                tvName.text = todo.name
            }
        }
    }
}