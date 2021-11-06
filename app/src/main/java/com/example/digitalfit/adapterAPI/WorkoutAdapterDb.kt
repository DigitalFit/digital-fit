package com.example.digitalfit.adapterAPI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfit.databinding.WorkoutItemBinding
import com.example.digitalfit.modelDb.WorkoutDb

class WorkoutAdapterDb(private var onEdit: (WorkoutDb) -> Unit, private var onDelete: (WorkoutDb) -> Unit, private var onDetail: (WorkoutDb) -> Unit) :
    ListAdapter<WorkoutDb, WorkoutAdapterDb.WorkoutListViewHolder>(WorkoutDiffCallback()) {

    class WorkoutListViewHolder(
        private val binding: WorkoutItemBinding,
        private var onEdit: (WorkoutDb) -> Unit,
        private var onDelete: (WorkoutDb) -> Unit,
        private var onDetail: (WorkoutDb) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var workoutId: Long = -1
        private var nameView = binding.tvWorkout
       // private var description = binding.description
        private var workout: WorkoutDb? = null

        fun bind(workout: WorkoutDb) {
            workoutId = workout.workoutId
            nameView.text = workout.name
           // description.text = workout.description
           // thumbnail.setImageResource(R.drawable.donut_with_sprinkles)
            this.workout = workout
            binding.ibDeleteWorkout.setOnClickListener {
                onDelete(workout)
            }
            binding.ibEditWorkout.setOnClickListener {
                onEdit(workout)
            }
            binding.root.setOnClickListener {
                onDetail(workout)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutListViewHolder {

        return WorkoutListViewHolder(
            WorkoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onEdit,
            onDelete,
            onDetail
        )
    }

    override fun onBindViewHolder(holder: WorkoutListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class WorkoutDiffCallback : DiffUtil.ItemCallback<WorkoutDb>() {
    override fun areItemsTheSame(oldItem: WorkoutDb, newItem: WorkoutDb): Boolean {
        return oldItem.workoutId == newItem.workoutId
    }

    override fun areContentsTheSame(oldItem: WorkoutDb, newItem: WorkoutDb): Boolean {
        return oldItem == newItem
    }
}