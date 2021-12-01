package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class WorkoutWithExerciseAndImages(
    @Embedded val workout: WorkoutDb,
    @Relation(
        entity = ExerciseDb::class,
        parentColumn = "workoutId",
        entityColumn = "exerciseId",
        associateBy = Junction(ExerciseWorkoutCrossRef::class)
    )
    val exerciseWithImages: List<ExerciseWithImages>
)
