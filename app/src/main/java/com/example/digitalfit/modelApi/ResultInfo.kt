package com.example.digitalfit.modelApi


data class ResultInfo(
    val id: Int,
    val category: Category,
    val comments: List<Comment>,
    val creation_date: String,
    val description: String,
    val equipment: List<Equipment>,
    val images: List<Image>,
    val language: Language,
    val license: License,
    val license_author: String,
    val muscles: List<Muscle>,
    val muscles_secondary: List<MusclesSecondary>,
    val name: String,
    val uuid: String,
)