package com.example.todolist.model

import java.math.BigDecimal

data class UserItem(
    val id: String,
    var link: String,
    var name: String,
    var price: BigDecimal?
)