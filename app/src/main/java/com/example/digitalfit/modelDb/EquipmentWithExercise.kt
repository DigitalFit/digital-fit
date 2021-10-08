package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class EquipmentWithExercise(
    @Embedded val equipment: EquipmentDb,
    @Relation(
        parentColumn = "equipmentId",
        entityColumn = "exerciseId",
        associateBy = Junction(ExerciseEquipmentCrossRef::class)
    )
    val exercise: List<ExerciseDb>
)
