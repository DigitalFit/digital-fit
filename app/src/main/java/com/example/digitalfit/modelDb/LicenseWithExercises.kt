package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.google.android.material.shape.ShapePath
import kotlinx.parcelize.Parcelize


data class LicenseWithExercises(

    @Embedded val license: License,
    @Relation(
        parentColumn = "licenseId",
        entityColumn = "exerciseId"
    )
    val exercise: Exercise
)
