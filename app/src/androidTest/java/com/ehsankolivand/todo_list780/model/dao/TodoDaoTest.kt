package com.ehsankolivand.todo_list780.model.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ehsankolivand.todo_list780.model.database.TodoDatabaseTest
import com.ehsankolivand.todo_list780.utils.ModelGenerator
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
 class TodoDaoTest:TodoDatabaseTest() {

    lateinit var todoDao: TodoDao

    @Before
    fun init() {
        todoDao = todoListDatabase.getTodoDao()
    }


    @Test
    fun testInsertTask() = runBlocking {
        val taskA = ModelGenerator.createTask()
        val id = todoDao.insert(taskA)
        val taskB = todoDao.findTaskById(id).firstOrNull()
        assert(taskB?.title == taskA.title)
    }
}