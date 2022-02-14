package com.ehsankolivand.todo_list780.model.dao

import androidx.room.Dao
import androidx.room.Query
import com.ehsankolivand.todo_list780.model.entites.TodoModel
import kotlinx.coroutines.flow.Flow

@Dao
abstract class TodoDao : BaseDao<TodoModel> {


    @Query("SELECT * FROM TodoModel ORDER BY id ASC")
    abstract fun getAllTasks(): Flow<List<TodoModel>>

    @Query("SELECT * FROM TodoModel WHERE id = :id")
    abstract fun findTaskById(id: Long): Flow<TodoModel>


    @Query("DELETE FROM TodoModel")
    abstract suspend fun deleteAllTasks()


    @Query("SELECT * FROM TodoModel WHERE title LIKE :searchQuery")
    abstract fun searchTasks(searchQuery: String): Flow<List<TodoModel>>


}