package com.example.digitalfit.adapterAPI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitalfit.R
import com.example.digitalfit.databinding.ExerciseItemBinding
import com.example.digitalfit.databinding.WorkoutItemBinding
import com.example.digitalfit.modelDb.ExerciseDb
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.WorkoutDb
import com.example.digitalfit.modelDb.WorkoutWithExercise

class WorkoutExerciseAdapterDb(
    private var onDelete: (ExerciseWithImages) -> Unit,
    private var onDetail: (ExerciseWithImages) -> Unit
) :
    ListAdapter<ExerciseWithImages, WorkoutExerciseAdapterDb.WorkoutExerciseListViewHolder>(
        WorkoutExerciseDiffCallback()
    ) {

    class WorkoutExerciseListViewHolder(
        private val binding: ExerciseItemBinding,
        private var onDelete: (ExerciseWithImages) -> Unit,
        private var onDetail: (ExerciseWithImages) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var exerciseId: Int = -1
        private var nameView = binding.tvExercise
        private var exercise: ExerciseWithImages? = null

        fun bind(exercises: ExerciseWithImages) {
            exerciseId = exercises.exercise.exerciseId
            nameView.text = exercises.exercise.name
            this.exercise = exercises

            with(binding) {

                ibExercise.isGone = false

                //se imagem nao for null, carrega primeira imagem da lista
                Glide
                    .with(itemView.context)
                    .load(exercises.image.firstOrNull()?.image)
                    .placeholder(R.drawable.noimage)
                    .into(ivExercise)


                ibExercise.setOnClickListener {
                    onDelete(exercises)
                }
                root.setOnClickListener {
                    onDetail(exercises)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkoutExerciseListViewHolder {

        return WorkoutExerciseListViewHolder(
            ExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onDelete,
            onDetail
        )
    }

    override fun onBindViewHolder(holder: WorkoutExerciseListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class WorkoutExerciseDiffCallback : DiffUtil.ItemCallback<ExerciseWithImages>() {
    override fun areItemsTheSame(
        oldItem: ExerciseWithImages,
        newItem: ExerciseWithImages
    ): Boolean {
        return oldItem.exercise.exerciseId == newItem.exercise.exerciseId
    }

    override fun areContentsTheSame(
        oldItem: ExerciseWithImages,
        newItem: ExerciseWithImages
    ): Boolean {
        return oldItem.exercise.exerciseId == newItem.exercise.exerciseId
    }
}