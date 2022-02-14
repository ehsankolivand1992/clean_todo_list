package com.ehsankolivand.todo_list780.usecases

import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.model.repository.TodoRepository

class FindTodoUseCase(private val repository: TodoRepository<TodoModel>) {

     operator fun invoke(id: Long)=repository.findTodoById(id)
}