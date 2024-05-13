package com.example.newtodolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter (private var tasks: List<Task>, context: Context): RecyclerView.Adapter<TasksAdapter.TaskViewHolder>(){

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val priorityTextView: TextView = itemView.findViewById(R.id.priorityTextView)
        val deadLineTextView: TextView = itemView.findViewById(R.id.deadLineTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
//        val editButton: ImageView = itemView.findViewById(R.id.updateIcon)
//        val deleteButton: ImageView = itemView.findViewById(R.id.deleteIcon)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.titleTextView.text = task.title
        holder.priorityTextView.text = task.priority
        holder.deadLineTextView.text =task.deadLine
        holder.contentTextView.text =task.description

//        holder.editButton.setOnClickListener{
//            val intent =Intent(holder.itemView.context, UpdateNotes::class.java).apply {
//                putExtra("diary_id", currentDiary.id)
//            }
//            holder.itemView.context.startActivity(intent)
//        }
//
//        holder.deleteButton.setOnClickListener{
//            db.deleteNote(currentDiary.id)
//            refreshData(db.getAllNotes())
//            Toast.makeText(holder.itemView.context, "Note Deleted", Toast.LENGTH_SHORT).show()
//        }
    }

    fun refreshData(newTasks : List<Task>){
        tasks = newTasks
        notifyDataSetChanged()

    }
}