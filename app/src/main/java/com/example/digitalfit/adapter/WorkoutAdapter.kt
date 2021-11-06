package com.example.digitalfit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfit.databinding.WorkoutItemBinding
import com.example.digitalfit.model.Workout

class WorkoutAdapter (
    private val workoutList: List<Workout>,
    private val onClickListener: (workout: Workout) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = WorkoutItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder) {
            holder.bind(workoutList[position], onClickListener)
        }
    }

    override fun getItemCount() = workoutList.size

    class ViewHolder(
        val binding: WorkoutItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            workout: Workout,
            onClickListener: (workout: Workout) -> Unit,
        ) {
            binding.tvWorkout.text = workout.name
            binding.tvQuantityVal.text = workout.quantity.toString()
            binding.tvDurationVal.text = workout.duration.toString()
        }

    }

}