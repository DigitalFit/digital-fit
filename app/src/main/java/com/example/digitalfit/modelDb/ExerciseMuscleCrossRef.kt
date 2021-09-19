package com.example.digitalfit.modelDb

import androidx.room.Entity

@Entity(primaryKeys = ["exerciseId", "muscleId"])
data class ExerciseMuscleCrossRef(
    val exerciseId: Int?,
    val muscleId: Int?
    )
