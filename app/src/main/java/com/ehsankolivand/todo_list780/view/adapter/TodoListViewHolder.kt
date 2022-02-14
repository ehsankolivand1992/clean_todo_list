package com.ehsankolivand.todo_list780.view.adapter

import android.content.Context
import com.ehsankolivand.todo_list780.core.base.BaseViewHolder
import com.ehsankolivand.todo_list780.databinding.TodoRowBinding
import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.utils.toShow

class TodoListViewHolder(override val binding: TodoRowBinding, override val context: Context) :
    BaseViewHolder<TodoModel>(binding, context) {

    override fun bind(todoModel: TodoModel, clicked: (task: TodoModel) -> Unit) {
        binding.titleText.text = todoModel.title
        binding.creationDateText.text = todoModel.date.toShow()

        binding.root.setOnClickListener {
            clicked(todoModel)
        }
    }



}
