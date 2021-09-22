package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.digitalfit.modelApi.MusclesSecondary
import kotlinx.parcelize.Parcelize


data class MusclesSecondaryWithExercise(
    @Embedded val musclesSecondary: List<MusclesSecondary>,
    @Relation(
        parentColumn = "musclesSecondaryId",
        entityColumn = "exerciseId",
        associateBy = Junction(ExerciseWithMusclesSecondary::class)
    )
    val exercise: Exercise
)
