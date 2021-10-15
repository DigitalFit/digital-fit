package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.LanguageDb
import com.example.digitalfit.modelDb.LanguageWithExercise

@Dao
interface LanguageDao {
    
    @Query("SELECT * FROM language")
    suspend fun getAllLanguage(): List<LanguageDb>

    @Query("SELECT * FROM language WHERE languageId = :languageId")
    suspend fun loadLanguageById (languageId: Int): List<LanguageDb>

    @Transaction
    @Query("SELECT * FROM language")
    suspend fun getExerciseWithLanguage(): List<LanguageWithExercise>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLanguages (languagesList: List<LanguageDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLanguage (language: LanguageDb)

    @Delete
    suspend fun delete(language: LanguageDb)

}