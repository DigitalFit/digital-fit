package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ExerciseWithWorkout(
    @Embedded val exercise: ExerciseDb,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "workoutId",
        associateBy = Junction(ExerciseWorkoutCrossRef::class)
    )
    val workout: List<WorkoutDb>
)