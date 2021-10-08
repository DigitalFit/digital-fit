package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Relation


data class ExerciseWithComments(

    @Embedded val exercise: ExerciseDb,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "exerciseId"
    )
    val commentDb: List<CommentDb>
)