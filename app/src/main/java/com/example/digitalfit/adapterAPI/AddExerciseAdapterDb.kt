package com.example.digitalfit.adapterAPI
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.digitalfit.R
//import com.example.digitalfit.databinding.ExerciseItemBinding
//import com.example.digitalfit.databinding.WorkoutItemBinding
//import com.example.digitalfit.modelDb.ExerciseWithImages
//import com.example.digitalfit.modelDb.WorkoutDb
//
//class AddExerciseAdapterDb(private var onEdit: (ExerciseWithImages) -> Unit, private var onDelete: (ExerciseWithImages) -> Unit, private var onDetail: (ExerciseWithImages) -> Unit) :
//    ListAdapter<ExerciseWithImages, AddExerciseAdapterDb.AddExerciseListViewHolder>(AddExerciseDiffCallback()) {
//
//    class AddExerciseListViewHolder(
//        private val binding: ExerciseItemBinding,
//        private var onEdit: (ExerciseWithImages) -> Unit,
//        private var onDelete: (ExerciseWithImages) -> Unit,
//        private var onDetail: (ExerciseWithImages) -> Unit
//    ) : RecyclerView.ViewHolder(binding.root) {
//        private var exerciseId: Long = -1
//        private var nameView = binding.tvExercise
//        // private var description = binding.description
//        private var workout: WorkoutDb? = null
//
//        fun bind(workout: WorkoutDb) {
//            workoutId = workout.workoutId
//            nameView.text = workout.name
//            // description.text = workout.description
//            // thumbnail.setImageResource(R.drawable.donut_with_sprinkles)
//            this.workout = workout
//            binding.ibDeleteWorkout.setOnClickListener {
//                onDelete(workout)
//            }
//            binding.ibEditWorkout.setOnClickListener {
//                onEdit(workout)
//            }
//            binding.root.setOnClickListener {
//                onDetail(workout)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddExerciseListViewHolder {
//
//        return AddExerciseListViewHolder(
//            WorkoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
//            onEdit,
//            onDelete,
//            onDetail
//        )
//    }
//
//    override fun onBindViewHolder(holder: AddExerciseListViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//}
//
//class AddExerciseDiffCallback : DiffUtil.ItemCallback<ExerciseWithImages>() {
//    override fun areItemsTheSame(oldItem: ExerciseWithImages, newItem: ExerciseWithImages): Boolean {
//        return oldItem.exercise.exerciseId == newItem.exercise.exerciseId
//    }
//
//    override fun areContentsTheSame(oldItem: ExerciseWithImages, newItem: ExerciseWithImages): Boolean {
//        return oldItem == newItem
//    }
//}