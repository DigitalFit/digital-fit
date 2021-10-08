package com.example.digitalfit.modelApi

data class MuscleExercises(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Muscle>
)