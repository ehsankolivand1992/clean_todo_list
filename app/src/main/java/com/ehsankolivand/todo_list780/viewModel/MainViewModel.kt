package com.ehsankolivand.todo_list780.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.usecases.AllTodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val allTodoUseCases: AllTodoUseCases)
    : ViewModel() {


    private val _BaseTodoDateObservable = MutableLiveData<List<TodoModel>>()

    val BaseTodoObservable: LiveData<List<TodoModel>> = _BaseTodoDateObservable

    init {
        viewModelScope.launch {
            fetchTodos()
        }
    }

    private suspend fun fetchTodos()
    {
        allTodoUseCases.getAllTodoUseCase.invoke().collect{
            _BaseTodoDateObservable.postValue(it)
        }
    }


    fun findTodoById(id:Long)=allTodoUseCases.findTodoUseCase.invoke(id).asLiveData()

    fun deleteTodo(todoModel: TodoModel)= viewModelScope.launch {
        allTodoUseCases.deleteTodoUseCase.invoke(todoModel)
    }

    fun insert(todoModel: TodoModel)  = liveData {
        emit(allTodoUseCases.insertTodoUseCase.invoke(todoModel))
    }


    fun update(todoModel: TodoModel)=viewModelScope.launch {
        allTodoUseCases.updateTodoUseCase.invoke(todoModel)
    }

    fun delete(todoModel: TodoModel) = viewModelScope.launch {
        allTodoUseCases.deleteTodoUseCase(todoModel)
    }

}