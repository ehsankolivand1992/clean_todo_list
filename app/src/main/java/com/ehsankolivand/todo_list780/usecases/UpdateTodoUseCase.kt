package com.ehsankolivand.todo_list780.usecases

import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.model.repository.TodoRepository

class UpdateTodoUseCase(private val repository: TodoRepository<TodoModel>) {

    suspend operator fun invoke(todoModel: TodoModel)=repository.update(todoModel)
}