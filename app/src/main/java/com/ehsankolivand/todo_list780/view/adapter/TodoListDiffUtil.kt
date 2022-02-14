package com.ehsankolivand.todo_list780.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ehsankolivand.todo_list780.model.entites.TodoModel


class TodoListDiffUtil(
    private val oldList: List<TodoModel>,
    private val newList: List<TodoModel>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
    ) = oldList[oldItemPosition] === newList[newItemPosition]

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
    ) = oldList[oldItemPosition] == newList[newItemPosition]
}