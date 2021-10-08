package com.example.digitalfit.modelApi
import com.example.digitalfit.modelDb.CategoryDb

data class Category(
    val id: Int,
    val name: String
)

fun Category.toCategoryDb(): CategoryDb {
    return CategoryDb(
        categoryId = this.id,
        name = this.name
    )
}