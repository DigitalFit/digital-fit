package com.example.digitalfit.modelApi

data class LicenseExercises(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<License>
)