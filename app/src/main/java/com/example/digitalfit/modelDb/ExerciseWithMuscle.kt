package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ExerciseWithMuscle(
    @Embedded val exercise: ExerciseDb,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "muscleId",
        associateBy = Junction(ExerciseMuscleCrossRef::class)
    )
    val muscle: List<MuscleDb>
)
