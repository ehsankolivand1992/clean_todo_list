package com.ehsankolivand.todo_list780.core.di.modules

import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.model.repository.TodoRepository
import com.ehsankolivand.todo_list780.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: TodoRepository<TodoModel>): AllTodoUseCases
    {
        return AllTodoUseCases(
            DeleteTodoUseCase(repository),
            FindTodoUseCase(repository),
            GetAllTodoUseCase(repository),
            InsertTodoUseCase(repository),
            UpdateTodoUseCase(repository),
        )
    }
}