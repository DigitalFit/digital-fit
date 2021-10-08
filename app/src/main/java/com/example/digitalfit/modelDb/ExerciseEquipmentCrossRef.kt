package com.example.digitalfit.modelDb

import androidx.room.Entity

@Entity(primaryKeys = ["exerciseId", "equipmentId"], tableName = "exercise_equipment")
data class ExerciseEquipmentCrossRef(
    val exerciseId: Int,
    val equipmentId: Int
)
