package com.example.digitalfit.modelApi

data class ImageExercises(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Image>
)