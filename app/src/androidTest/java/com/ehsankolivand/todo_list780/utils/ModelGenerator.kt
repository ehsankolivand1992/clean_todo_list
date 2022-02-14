package com.ehsankolivand.todo_list780.utils

import com.ehsankolivand.todo_list780.model.entites.TodoModel
import java.time.LocalDateTime

object ModelGenerator {
    fun createTask()=TodoModel(0,"test","Test", LocalDateTime.now())
}