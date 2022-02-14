package com.ehsankolivand.todo_list780.model.repository

import kotlinx.coroutines.flow.Flow

interface TodoRepository<T> {

    suspend fun insert(data: T): Long

    suspend fun insertAll(data: List<T>)

    fun getAllTodos(): Flow<List<T>>

    fun findTodoById(id: Long): Flow<T>

    suspend fun update(data: T)

    suspend fun delete(data: T)

}