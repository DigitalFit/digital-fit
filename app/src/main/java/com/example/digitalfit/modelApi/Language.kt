package com.example.digitalfit.modelApi

import com.example.digitalfit.modelDb.LanguageDb

data class Language(
    val id: Int,
    val full_name: String,
    val short_name: String
)

fun Language.toLanguageDb(): LanguageDb {
    return LanguageDb(
        languageId = this.id,
        full_name = this.full_name,
        short_name = this.short_name
    )
}