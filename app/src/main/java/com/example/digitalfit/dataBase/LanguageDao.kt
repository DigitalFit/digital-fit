package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.Language

@Dao
interface LanguageDao {
    
    @Query("SELECT * FROM language")
    suspend fun getAllLanguage(): List<Language>

    @Query("SELECT * FROM language WHERE languageId = :languageId")
    suspend fun loadLanguageById (languageId: Int): List<Language>

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExerciseWithLanguage(): List<Language>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLanguages (languagesList: List<Language>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLanguage (language: Language)

    @Delete
    suspend fun delete(language: Language)

}