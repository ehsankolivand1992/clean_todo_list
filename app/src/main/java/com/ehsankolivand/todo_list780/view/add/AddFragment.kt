package com.ehsankolivand.todo_list780.view.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ehsankolivand.todo_list780.R
import com.ehsankolivand.todo_list780.core.base.BaseFragment
import com.ehsankolivand.todo_list780.databinding.FragmentAddBinding
import com.ehsankolivand.todo_list780.model.entites.TodoModel
import com.ehsankolivand.todo_list780.view.MainActivity
import com.ehsankolivand.todo_list780.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime

@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding>() {


    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setBinding()= FragmentAddBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_add)
        {
            mainViewModel.insert(TodoModel(0,binding.titleEt.text.toString()
                ,binding.descriptionEt.text.toString(), LocalDateTime.now())).observe(requireActivity()
            ) {}
        }
        findNavController().navigateUp()

        return super.onOptionsItemSelected(item)
    }
}