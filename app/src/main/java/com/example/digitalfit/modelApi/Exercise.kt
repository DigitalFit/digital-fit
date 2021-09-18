package com.example.digitalfit.modelApi

import androidx.room.Embedded

data class Exercise(
    val id: Int,
    @Embedded
    val category: Category,
    @Embedded
    val comments: List<Comment>,
    val creation_date: String,
    val description: String,
    @Embedded
    val equipment: List<Equipment>,
    @Embedded
    val images: List<Image>,
    @Embedded
    val language: Language,
    @Embedded
    val license: License,
    val license_author: String,
    @Embedded
    val muscles: List<Muscle>,
    @Embedded
    val muscles_secondary: List<MusclesSecondary>,
    val name: String,
    val uuid: String,
)