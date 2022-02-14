package com.ehsankolivand.todo_list780.usecases

import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.model.repository.TodoRepository

class DeleteTodoUseCase(private val repository: TodoRepository<TodoModel>) {

    suspend operator fun invoke(taskModel: TodoModel)
    {
        repository.delete(taskModel)
    }
}