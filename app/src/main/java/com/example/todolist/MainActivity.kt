package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.TodoAdapter
import com.example.todolist.adapter.UserItemAdapter
import com.example.todolist.model.Todo
import com.example.todolist.model.UserItem
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var userItemAdapter: UserItemAdapter

    //для обеспечения взаимодействия между компонентами используется адаптер
    //private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userItemAdapter = UserItemAdapter(userItemsStub())

        rvTodoItems.adapter = userItemAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        //кнопки работают с адаптером
        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
//                val todo = Todo(todoTitle)
//                todoAdapter.addTodo(todo)
//                etTodoTitle.text.clear()
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
//            todoAdapter.deleteDoneTodos()
        }
    }
}

fun userItemsStub() = mutableListOf(
    UserItem("1", "http://mvideo.ru/brush", "Зубная щетка", BigDecimal.valueOf(1000)),
    UserItem("2", "http://mvideo.ru/tooth_cord", "Зубная нить", BigDecimal.valueOf(100))
)