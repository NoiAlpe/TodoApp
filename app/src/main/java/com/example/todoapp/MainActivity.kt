package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.btnNewTask.setOnClickListener{
            NewTaskSheet().show(supportFragmentManager, "newTaskTag")
        }

        taskViewModel.name.observe(this){
            binding.tvTaskName.text = String.format("Task Name: %s", it)
        }

        taskViewModel.desc.observe(this){
            binding.tvTaskDesc.text = String.format("Task Desc: %s", it)
        }
    }
}