package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class LanguagesWithExercise(

    @Embedded val language: Language,
    @Relation(
        parentColumn = "languageId",
        entityColumn = "exerciseId"
    )
    val exercise: Exercise
): Parcelable{

}
