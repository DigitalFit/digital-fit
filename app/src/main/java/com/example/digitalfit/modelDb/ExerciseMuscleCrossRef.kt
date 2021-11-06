package com.example.digitalfit.modelDb

import androidx.room.Entity

@Entity(primaryKeys = ["exerciseId", "muscleId"], tableName = "exercise_muscle")
data class ExerciseMuscleCrossRef(
    val exerciseId: Int,
    val muscleId: Int
)
