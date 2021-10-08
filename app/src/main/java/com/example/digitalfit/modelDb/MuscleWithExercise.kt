package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class MuscleWithExercise(
    @Embedded val muscle: MuscleDb,
    @Relation(
        parentColumn = "muscleId",
        entityColumn = "exerciseId",
        associateBy = Junction(ExerciseMuscleCrossRef::class)
    )
    val exercise: List<ExerciseDb>
)
