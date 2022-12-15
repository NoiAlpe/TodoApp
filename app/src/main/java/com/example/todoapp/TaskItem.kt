package com.example.todoapp

import android.content.Context
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskItem (
    var name: String,
    var desc: String,
    var dueTime: LocalTime?,
    var completedDate: LocalDate?,
    var id: UUID = UUID.randomUUID()

){
    fun isCompleted() = completedDate != null
    fun imageResource(): Int = if (isCompleted()) R.drawable.checked else R.drawable.unchecked
    fun imageColor(context: Context): Int = if (isCompleted()) purple(context) else grey(context)

    private fun purple(context: Context) =  ContextCompat.getColor(context, R.color.purple_500)
    private fun grey(context: Context) =  ContextCompat.getColor(context, androidx.appcompat.R.color.material_grey_600)


}