package com.ehsankolivand.todo_list780.view.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.todo_list780.R
import com.ehsankolivand.todo_list780.core.base.BaseFragment
import com.ehsankolivand.todo_list780.databinding.FragmentListBinding
import com.ehsankolivand.todo_list780.view.MainActivity
import com.ehsankolivand.todo_list780.view.adapter.SwipeToDelete
import com.ehsankolivand.todo_list780.view.adapter.TodoListAdapter
import com.ehsankolivand.todo_list780.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>() {

    private val mainViewModel: MainViewModel by viewModels()

    lateinit var todoListAdapter: TodoListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false);

        initRecyclerview()
        initFab()

    }
    private fun initFab() {
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }


    private fun initRecyclerview() {
        todoListAdapter = TodoListAdapter(requireContext()) {
            val bundle = bundleOf("TodoId" to it.id)
            findNavController().navigate(R.id.action_listFragment_to_updateFragment,bundle)

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.isNestedScrollingEnabled = true
        binding.recyclerView.adapter = todoListAdapter
        mainViewModel.BaseTodoObservable.observe(requireActivity()) {
            todoListAdapter.setData(it)
        }

        swipeToDelete(binding.recyclerView)

    }
    override fun setBinding()= FragmentListBinding.inflate(layoutInflater)



    private fun swipeToDelete(recyclerView: RecyclerView) {
        val swipeToDeleteCallback = object: SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val itemToDelete = todoListAdapter.todoList[viewHolder.adapterPosition]
                mainViewModel.delete(itemToDelete)
                todoListAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}