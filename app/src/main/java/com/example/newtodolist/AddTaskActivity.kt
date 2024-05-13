package com.example.newtodolist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newtodolist.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddTaskBinding
    private lateinit var db: TaskDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val priority = binding.priorityEditText.text.toString()
            val deadLine = binding.deadLineEditText.text.toString()
            val description  = binding.contentEditText.text.toString()

            val task = Task(0, title, priority,deadLine, description)
            db.insertTasks(task)
            finish()
            Toast.makeText(this@AddTaskActivity, "Task Saved", Toast.LENGTH_SHORT).show()
        }

    }
}