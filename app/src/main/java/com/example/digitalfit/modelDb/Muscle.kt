package com.example.digitalfit.modelDb

data class Muscle(
    val id: Int,
    val image_url_main: String,
    val image_url_secondary: String,
    val is_front: Boolean,
    val name: String
)