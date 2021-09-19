package com.example.digitalfit.modelDb

import androidx.room.Entity

@Entity(primaryKeys = ["exerciseId", "musclesSecondaryId"])
data class ExerciseMusclesSecondaryCrossRef(
    val exerciseId: Int?,
    val musclesSecondaryId: Int?
)
