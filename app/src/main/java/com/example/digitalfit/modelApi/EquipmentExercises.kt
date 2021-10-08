package com.example.digitalfit.modelApi

data class EquipmentExercises(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Equipment>
)