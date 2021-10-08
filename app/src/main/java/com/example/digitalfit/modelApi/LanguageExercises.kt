package com.example.digitalfit.modelApi

data class LanguageExercises(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Language>
)
