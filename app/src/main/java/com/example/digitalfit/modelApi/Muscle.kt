package com.example.digitalfit.modelApi

import com.example.digitalfit.modelDb.MuscleDb


data class Muscle(
    val id: Int,
    val image_url_main: String,
    val image_url_secondary: String,
    val is_front: Boolean,
    val name: String
)

fun Muscle.toMuscleDb(): MuscleDb {
    return MuscleDb(
        muscleId = this.id,
        image_url_main = this.image_url_main,
        image_url_secondary = this.image_url_secondary,
        is_front = this.is_front,
        name = this.name
    )
}