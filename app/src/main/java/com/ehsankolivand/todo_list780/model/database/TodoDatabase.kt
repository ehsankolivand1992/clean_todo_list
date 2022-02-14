package com.ehsankolivand.todo_list780.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ehsankolivand.todo_list780.model.dao.TodoDao
import com.ehsankolivand.todo_list780.model.database.converters.Converters
import com.ehsankolivand.todo_list780.model.entites.TodoModel

/**
 * room database class
 * */

@Database(entities = [TodoModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao
}
