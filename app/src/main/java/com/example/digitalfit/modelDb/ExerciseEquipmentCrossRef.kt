package com.example.digitalfit.modelDb

import androidx.room.Entity

@Entity(primaryKeys = ["exerciseId", "equipmentId"])
data class ExerciseEquipmentCrossRef(
    val exerciseId: Int?,
    val equipmentId: Int?
)
