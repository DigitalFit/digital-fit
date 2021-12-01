package com.example.digitalfit.modelDb

import androidx.room.Entity

@Entity(primaryKeys = ["exerciseId", "workoutId"], tableName = "exercise_workout")
class ExerciseWorkoutCrossRef (
    val exerciseId: Int,
    val workoutId: Long
)