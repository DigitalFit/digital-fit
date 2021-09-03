package com.example.digitalfit.modelApi

data class Result(
    val category: Int,
    val creation_date: String,
    val description: String,
    val equipment: List<Int>,
    val exercise_base: Int,
    val id: Int,
    val language: Int,
    val license: Int,
    val license_author: String,
    val muscles: List<Int>,
    val muscles_secondary: List<Int>,
    val name: String,
    val status: String,
    val uuid: String,
    val variations: List<Int>
)