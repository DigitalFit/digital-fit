package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class EquipmentWithExercise(
    @Embedded val equipment: List<Equipment>,
    @Relation(
        parentColumn = "equipmentId",
        entityColumn = "exerciseId",
        associateBy = Junction(ExerciseEquipmentCrossRef::class)
    )
    val exercise:Exercise
): Parcelable{

}
