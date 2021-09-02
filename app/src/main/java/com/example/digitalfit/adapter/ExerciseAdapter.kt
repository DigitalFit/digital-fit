package com.example.digitalfit.adapter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.model.Exercise

class ExerciseAdapter (
    private val exerciseList: List<Exercise>,
    private val onClickListener: (exercise: Exercise) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ExerciseItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder) {
            holder.bind(exerciseList[position], onClickListener)
        }
    }

    override fun getItemCount() = exerciseList.size

    class ViewHolder(
        val binding: ExerciseItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            exercise: Exercise,
            onClickListener: (exercise: Exercise) -> Unit,
        ) {
            binding.tvExercise.text = exercise.name
            binding.ivExercise.setImageResource(exercise.avatar)
            binding.ibExercise.setOnClickListener {
              it.isSelected = !it.isSelected
            }
            //binding.ibExercise.setImageResource(exercise.icon)
        }

    }

}