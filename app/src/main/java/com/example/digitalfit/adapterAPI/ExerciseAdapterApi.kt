package com.example.digitalfit.adapterAPI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitalfit.R
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.modelApi.Result

class ExerciseAdapterApi(
    private val exercisesList: List<Result>,
    private val onClickListener: (exercises: Result) -> Unit
) : RecyclerView.Adapter<ExerciseAdapterApi.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ExerciseItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exercisesList[position], onClickListener)
    }

    override fun getItemCount() = exercisesList.size

    class ViewHolder(
        val binding: ExerciseItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            exercises: Result,
            onClickListener: (exercises: Result) -> Unit,
        ) {
            with(binding) {
              tvExercise.text = exercises.uuid
                cvExercise.setOnClickListener {
                    onClickListener(exercises)
                }
                Glide
                    .with(itemView.context)
                    .load(exercises.image)
                    .placeholder(R.drawable.noimage)
                    .into(ivExercise)
                }
            }
        }
    }
