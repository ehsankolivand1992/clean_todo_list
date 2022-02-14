package com.ehsankolivand.todo_list780.usecases


/**
 * hold all usecase CRUD in one Data Class
 * */
data class AllTodoUseCases(
    val deleteTodoUseCase: DeleteTodoUseCase,
    val findTodoUseCase: FindTodoUseCase,
    val getAllTodoUseCase: GetAllTodoUseCase,
    val insertTodoUseCase: InsertTodoUseCase,
    val updateTodoUseCase: UpdateTodoUseCase
)
