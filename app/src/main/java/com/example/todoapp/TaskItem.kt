package com.example.todoapp

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Entity(tableName = "tableTaskItem")
class TaskItem (
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "dueTime") var dueTimeString: String?,
    @ColumnInfo(name = "completedDate") var completedDateString: String?,
    @PrimaryKey(autoGenerate = true) var id: Int = 0

){

    private fun completedDate(): LocalDate? = if(completedDateString == null) null else LocalDate.parse(completedDateString, dateFormatter)
    fun dueTime(): LocalTime? = if(dueTimeString == null) null else LocalTime.parse(dueTimeString, timeFormatter)

    fun isCompleted() = completedDate() != null

    fun imageResource(): Int = if (isCompleted()) R.drawable.checked else R.drawable.unchecked
    fun imageColor(context: Context): Int = if (isCompleted()) purple(context) else grey(context)

    private fun purple(context: Context) =  ContextCompat.getColor(context, R.color.purple_500)
    private fun grey(context: Context) =  ContextCompat.getColor(context, androidx.appcompat.R.color.material_grey_600)

    companion object {
        val timeFormatter: DateTimeFormatter = DateTimeFormatter.ISO_TIME
        val dateFormatter: DateTimeFormatter = DateTimeFormatter.ISO_DATE
    }

}