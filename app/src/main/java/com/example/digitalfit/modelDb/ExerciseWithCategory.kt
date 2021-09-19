package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class ExerciseWithCategory(

    @Embedded val exercise: Exercise,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "categoryId"
    )
    val category: Category
): Parcelable{

}
