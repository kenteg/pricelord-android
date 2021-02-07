package com.example.todolist.model

data class Todo(
    val title: String,
    var isChecked: Boolean = false
)