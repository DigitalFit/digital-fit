package com.example.digitalfit.dataBase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.digitalfit.modelDb.*

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    suspend fun getAllExercises(): List<ExerciseDb>

    @Query("SELECT * FROM exercise WHERE exerciseId = :exerciseId")
    suspend fun loadExerciseById(exerciseId: Int): ExerciseDb

    @Transaction
    @Query("SELECT * FROM exercise LIMIT 20 OFFSET :offset")
    suspend fun getExerciseWithImages(offset: Int): List<ExerciseWithImages>

    @Transaction
    @Query("SELECT * FROM exercise WHERE exerciseId = :exerciseId")
    suspend fun getExerciseWithImagesById(exerciseId: Int): ExerciseWithImages


    @Insert(onConflict = REPLACE)
    suspend fun insertAllExercises(exerciseList: List<ExerciseDb>)

    @Insert(onConflict = REPLACE)
    suspend fun insertExercise(exercise: ExerciseDb)

    @Delete
    suspend fun delete(exercise: ExerciseDb)
}