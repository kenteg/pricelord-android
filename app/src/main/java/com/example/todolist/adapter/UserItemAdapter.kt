package com.example.todolist.adapter

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.model.Todo
import com.example.todolist.model.UserItem
import kotlinx.android.synthetic.main.item_todo.view.*

//адаптер для обращения с компонентами листа
class UserItemAdapter(
    //хранилище данных
    private val userItems: MutableList<UserItem>
) : RecyclerView.Adapter<UserItemAdapter.UserItemViewHolder>() {

    class UserItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        return UserItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                //привязка layout
                R.layout.userItem,
                parent,
                false
            )
        )
    }

    fun addTodo(todo: Todo) {
        userItems.add(todo)
        notifyItemInserted(userItems.size - 1)
    }

    fun deleteDoneTodos() {
        userItems.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    //обновление view в момент биндинга на главную форму
    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val curTodo = userItems[position]
        holder.itemView.apply {
            tvTodoTitle.text = curTodo.title
            cbDone.isChecked = curTodo.isChecked
            toggleStrikeThrough(tvTodoTitle, curTodo.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvTodoTitle, isChecked)
                curTodo.isChecked = !curTodo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return userItems.size
    }
}


















