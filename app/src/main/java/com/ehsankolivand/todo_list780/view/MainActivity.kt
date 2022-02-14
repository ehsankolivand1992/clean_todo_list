package com.ehsankolivand.todo_list780.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ehsankolivand.todo_list780.R
import com.ehsankolivand.todo_list780.core.base.BaseActivity
import com.ehsankolivand.todo_list780.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.topToolbar);

    }


    override fun setBinding() = ActivityMainBinding.inflate(layoutInflater)
}
