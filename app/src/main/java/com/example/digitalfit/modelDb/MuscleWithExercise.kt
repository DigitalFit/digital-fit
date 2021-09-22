package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class MuscleWithExercise(
    @Embedded val muscle: List<Muscle>,
    @Relation(
        parentColumn = "muscleId",
        entityColumn = "exerciseId",
        associateBy = Junction(ExerciseMuscleCrossRef::class)
    )
    val exercise: Exercise
): Parcelable{

}
