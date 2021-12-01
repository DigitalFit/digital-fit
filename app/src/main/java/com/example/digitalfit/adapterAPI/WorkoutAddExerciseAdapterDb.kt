package com.example.digitalfit.adapterAPI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitalfit.R
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.databinding.WorkoutAddExerciseItemBinding
import com.example.digitalfit.databinding.WorkoutItemBinding
import com.example.digitalfit.features.workoutaddexercise.view.WorkoutAddExerciseFragmentArgs
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ExerciseWorkoutCrossRef
import com.example.digitalfit.modelDb.WorkoutDb

class WorkoutAddExerciseAdapterDb(
    private var onInsert: (Int) -> Unit,
    private var onDetail: (ExerciseWithImages) -> Unit
) : PagedListAdapter<ExerciseWithImages, WorkoutAddExerciseAdapterDb.ViewHolder>(ExerciseWithImages.DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            WorkoutAddExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onInsert,
            onDetail
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(
        val binding: WorkoutAddExerciseItemBinding,
        private var onInsert: (Int) -> Unit,
        private var onDetail: (ExerciseWithImages) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            exercises: ExerciseWithImages?,
        ) {
            with(binding) {
                exercises?.let {
                    tvExercise.text = exercises.exercise.name
                    binding.root.setOnClickListener {
                        onDetail(exercises)
                    }
                    //se imagem nao for null, carrega primeira imagem da lista
                    Glide
                        .with(itemView.context)
                        .load(exercises.image.firstOrNull()?.image)
                        .placeholder(R.drawable.noimage)
                        .into(ivExercise)

                    ibExercise.setOnClickListener {
                        onInsert(exercises.exercise.exerciseId)
                    }
                }
            }
        }
    }
}