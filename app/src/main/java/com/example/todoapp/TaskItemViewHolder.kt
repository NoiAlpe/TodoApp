package com.example.todoapp

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder (
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener

    ): RecyclerView.ViewHolder(binding.root) {

        private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

        fun bindTaskItem(taskItem: TaskItem){
            binding.name.text = taskItem.name

            if (taskItem.isCompleted()){
                binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            binding.ibCompleteButton.setImageResource(taskItem.imageResource())
            binding.ibCompleteButton.setColorFilter(taskItem.imageColor(context))

            binding.ibCompleteButton.setOnClickListener{
                clickListener.completeTaskItem(taskItem)
            }

            binding.cvTaskCellContainer.setOnClickListener{
                clickListener.editTaskItem(taskItem)
            }

            if (taskItem.dueTime() != null) binding.dueTime.text = timeFormat.format(taskItem.dueTime())
            else binding.dueTime.text = ""
        }
}