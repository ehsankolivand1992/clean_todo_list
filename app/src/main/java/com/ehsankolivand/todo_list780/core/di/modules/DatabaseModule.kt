package com.ehsankolivand.todo_list780.core.di.modules

import android.content.Context
import androidx.room.Room
import com.ehsankolivand.todo_list780.model.database.TodoDatabase
import com.ehsankolivand.todo_list780.model.repository.TodoRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *In This Module, I've created a Room Database and provided it.
 * */

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(context,
        TodoDatabase::class.java,
        "todo_database")
        .build()

    @Singleton
    @Provides
    fun provideTodoRepositoryImp(taskListDatabase: TodoDatabase):TodoRepositoryImp
    {
        return TodoRepositoryImp(taskListDatabase)
    }
}