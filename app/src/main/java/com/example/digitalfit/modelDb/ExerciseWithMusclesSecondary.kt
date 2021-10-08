package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation


data class ExerciseWithMusclesSecondary(
    @Embedded val exercise: ExerciseDb,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "muscleId",
        associateBy = Junction(ExerciseMuscleSecondaryCrossRef::class)
    )
    val musclesSecondary: List<MuscleDb>
)
