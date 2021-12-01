package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class WorkoutWithExercise(
    @Embedded val workout: WorkoutDb,
    @Relation(
        parentColumn = "workoutId",
        entityColumn = "exerciseId",
        associateBy = Junction(ExerciseWorkoutCrossRef::class)
    )
    val exercise: List<ExerciseDb>
)
