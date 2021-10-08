package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Relation


data class CategoryWithExercise(

    @Embedded val category: CategoryDb,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    val exercise: List<ExerciseDb>
)
