package com.example.newtodolist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newtodolist.databinding.ActivityAddTaskBinding
import com.example.newtodolist.databinding.ActivityUpdateTaskBinding

class UpdateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateTaskBinding
    private lateinit var db : TaskDatabaseHelper
    private var taskID: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabaseHelper(this)

        taskID = intent.getIntExtra("task_id", -1)
        if(taskID == -1){
            finish()
            return
        }

        val task = db.getTaskById(taskID)
        binding.updateTitleEditText.setText(task.title)
        binding.updatePriorityEditText.setText(task.priority)
        binding.updateDeadLineEditText.setText(task.deadLine)
        binding.updateContentEditText.setText(task.description)

        binding.updateSaveButton.setOnClickListener{
            val newTitle = binding.updateTitleEditText.text.toString()
            val newPriority = binding.updatePriorityEditText.text.toString()
            val newDeadLine = binding.updateDeadLineEditText.text.toString()
            val newDescription = binding.updateContentEditText.text.toString()
            val updateTask = Task(taskID, newTitle,newPriority, newDeadLine,newDescription)
            db.updateTask(updateTask)
            finish()
            Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()
        }

    }
}