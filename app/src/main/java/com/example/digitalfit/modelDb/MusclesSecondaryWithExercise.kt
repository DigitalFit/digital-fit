package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation


data class MusclesSecondaryWithExercise(
    @Embedded val musclesSecondary: MuscleDb,
    @Relation(
        parentColumn = "muscleId",
        entityColumn = "exerciseId",
        associateBy = Junction(ExerciseMuscleSecondaryCrossRef::class)
    )
    val exercise: List<ExerciseDb>
)
