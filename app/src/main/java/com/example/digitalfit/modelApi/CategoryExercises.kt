package com.example.digitalfit.modelApi

data class CategoryExercises(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Category>
)