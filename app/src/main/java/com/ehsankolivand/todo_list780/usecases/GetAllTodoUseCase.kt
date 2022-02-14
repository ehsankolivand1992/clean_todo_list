package com.ehsankolivand.todo_list780.usecases

import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.model.repository.TodoRepository

class GetAllTodoUseCase (private val repository: TodoRepository<TodoModel>) {

    suspend operator fun invoke() = repository.getAllTodos()
}