package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.digitalfit.modelApi.MusclesSecondary
import kotlinx.parcelize.Parcelize


data class ExerciseWithMusclesSecondary(
    @Embedded val exercise: Exercise,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "musclesSecondaryId",
        associateBy = Junction(ExerciseWithMusclesSecondary::class)
    )
    val musclesSecondary: List<MusclesSecondary>
)
