package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation


data class ExerciseWithEquipment(
    @Embedded val exercise: ExerciseDb,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "equipmentId",
        associateBy = Junction(ExerciseEquipmentCrossRef::class)
    )
    val equipment: List<EquipmentDb>
)
