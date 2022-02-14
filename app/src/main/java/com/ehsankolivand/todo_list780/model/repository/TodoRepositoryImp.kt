package com.ehsankolivand.todo_list780.model.repository

import com.ehsankolivand.todo_list780.model.database.TodoDatabase
import com.ehsankolivand.todo_list780.model.entites.TodoModel

/**
 * Todo Repository Created, and I've used it in my use cases.
 * */

 class TodoRepositoryImp(private val database: TodoDatabase) : TodoRepository<TodoModel> {

    private val todoDao = database.getTodoDao()

    override suspend fun insert(data: TodoModel): Long {
        return if (data.id == 0L) {
            todoDao.insert(data)
        } else {
            update(data)
            data.id
        }
    }

    override fun findTodoById(id: Long) = todoDao.findTaskById(id)

    override suspend fun insertAll(data: List<TodoModel>) {
        todoDao.insert(data)
    }

    override fun getAllTodos() = todoDao.getAllTasks()


    override suspend fun update(data: TodoModel) {
        todoDao.update(data)
    }

    override suspend fun delete(data: TodoModel) {
        todoDao.delete(data)
    }

}