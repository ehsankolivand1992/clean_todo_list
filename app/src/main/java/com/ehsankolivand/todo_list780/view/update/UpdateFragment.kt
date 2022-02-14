package com.ehsankolivand.todo_list780.view.update

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ehsankolivand.todo_list780.R
import com.ehsankolivand.todo_list780.core.base.BaseFragment
import com.ehsankolivand.todo_list780.databinding.FragmentUpdateBinding
import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.utils.toShow
import com.ehsankolivand.todo_list780.view.MainActivity
import com.ehsankolivand.todo_list780.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : BaseFragment<FragmentUpdateBinding>() {
    lateinit var todo: TodoModel
    private val mainViewModel: MainViewModel by viewModels()


    override fun setBinding() = FragmentUpdateBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val taskId = requireArguments().getLong("TodoId")

        mainViewModel.findTodoById(taskId).observe(viewLifecycleOwner){
            this.todo = it
            binding.titleEt.setText(it.title)
            binding.txtTime.text = it.date.toShow()
            binding.descriptionEt.setText(it.description)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_save)
        {
            todo.title = binding.titleEt.text.toString()
            todo.description = binding.descriptionEt.text.toString()
            mainViewModel.update(todo)
        }else if(item.itemId==R.id.menu_delete)
        {
            mainViewModel.delete(todo)
        }
        findNavController().navigateUp()
        return super.onOptionsItemSelected(item)
    }

}