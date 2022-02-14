package com.ehsankolivand.todo_list780.core.di.modules

import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.model.repository.TodoRepository
import com.ehsankolivand.todo_list780.model.repository.TodoRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface TaskRepositoryModule {

    @Singleton
    @Binds
    abstract fun provideTodoRepository(taskRepositoryImp: TodoRepositoryImp): TodoRepository<TodoModel>

}