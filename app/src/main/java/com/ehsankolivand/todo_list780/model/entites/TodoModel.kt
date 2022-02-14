package com.ehsankolivand.todo_list780.model.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    var title: String,
    var description:String,
    var date: LocalDateTime
)
