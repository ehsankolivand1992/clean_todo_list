package com.ehsankolivand.todo_list780.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.todo_list780.databinding.TodoRowBinding
import com.ehsankolivand.todo_list780.model.entites.TodoModel

class TodoListAdapter(
    private val context: Context,
    private val clicked: (todoModel: TodoModel) -> Unit,
) : RecyclerView.Adapter<TodoListViewHolder>() {

    var todoList = listOf<TodoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        return TodoListViewHolder(TodoRowBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false), context)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.bind(todoList[position], clicked)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun setData(newTodoList: List<TodoModel>) {
        val taskListDiffUtil = TodoListDiffUtil(todoList, newTodoList)
        val toDoDiffResult = DiffUtil.calculateDiff(taskListDiffUtil)
        this.todoList = newTodoList
        toDoDiffResult.dispatchUpdatesTo(this)
    }
}
