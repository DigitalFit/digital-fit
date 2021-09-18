package com.example.digitalfit.modelApi

data class InfoExercises(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultInfo>
)