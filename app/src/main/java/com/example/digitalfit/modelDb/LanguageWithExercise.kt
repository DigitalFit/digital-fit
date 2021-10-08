package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Relation

data class LanguageWithExercise(

    @Embedded val language: LanguageDb,
    @Relation(
        parentColumn = "languageId",
        entityColumn = "languageId"
    )
    val exercise: List<ExerciseDb>
)
