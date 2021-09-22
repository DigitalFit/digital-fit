package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import kotlinx.parcelize.Parcelize


data class ExerciseWithEquipment(
    @Embedded val exercise: Exercise,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "equipmentId",
        associateBy = Junction(ExerciseEquipmentCrossRef::class)
    )
    val equipment: List<Equipment>
)
