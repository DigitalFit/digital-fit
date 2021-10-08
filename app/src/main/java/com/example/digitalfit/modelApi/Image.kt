package com.example.digitalfit.modelApi

import com.example.digitalfit.modelDb.ImageDb

data class Image(
    val id: Int,
    val exercise_base: Int,
    val image: String,
    val is_main: Boolean,
    val status: String,
    val uuid: String
)

fun Image.toImageDb(exerciseId: Int): ImageDb {
    return ImageDb(
        imageId = this.id,
         exerciseId = exerciseId,
         exercise_base = this.exercise_base,
         image = this.image,
         is_main = this.is_main,
         status = this.status,
         uuid = this.uuid
    )
}