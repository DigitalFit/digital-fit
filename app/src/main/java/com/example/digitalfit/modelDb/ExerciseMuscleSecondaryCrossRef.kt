package com.example.digitalfit.modelDb

import androidx.room.Entity

@Entity(primaryKeys = ["exerciseId", "muscleId"], tableName = "exercise_muscle_secondary")
data class ExerciseMuscleSecondaryCrossRef(
    val exerciseId: Int,
    val muscleId: Int
)
