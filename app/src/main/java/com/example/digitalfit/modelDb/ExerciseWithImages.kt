package com.example.digitalfit.modelDb

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Embedded
import androidx.room.Relation
import com.example.digitalfit.modelApi.ResultInfo

data class ExerciseWithImages(

    @Embedded val exercise: ExerciseDb,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "exerciseId",
    )
    val image: List<ImageDb>

)
{
    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<ExerciseWithImages> =
            object : DiffUtil.ItemCallback<ExerciseWithImages>() {
                override fun areItemsTheSame(oldItem: ExerciseWithImages, newItem: ExerciseWithImages): Boolean {
                    return oldItem.exercise.exerciseId == newItem.exercise.exerciseId
                }

                override fun areContentsTheSame(oldItem: ExerciseWithImages, newItem: ExerciseWithImages): Boolean {
                    return oldItem.exercise.exerciseId == newItem.exercise.exerciseId
                }
            }
    }
}