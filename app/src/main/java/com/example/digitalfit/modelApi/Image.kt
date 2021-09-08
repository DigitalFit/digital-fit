package com.example.digitalfit.modelApi

data class Image(
    val exercise_base: Int,
    val id: Int,
    val image: String,
    val is_main: Boolean,
    val status: String,
    val uuid: String
)