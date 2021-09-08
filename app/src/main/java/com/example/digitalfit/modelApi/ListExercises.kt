package com.example.digitalfit.modelApi

data class ListExercises(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)