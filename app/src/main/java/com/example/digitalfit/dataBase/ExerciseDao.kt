package com.example.digitalfit.dataBase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.digitalfit.modelDb.Exercise

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    suspend fun getAllExercises(): List<Exercise>

    @Query("SELECT * FROM exercise WHERE id = :exerciseId")
   suspend fun loadExerciseById (exerciseId: Int): List<Exercise>

    @Insert(onConflict = REPLACE)
   suspend fun insertAllExercises (exercisesList: List<Exercise>)

   @Insert (onConflict = REPLACE)
   suspend fun insertExercise (exercise: Exercise)

    @Delete
   suspend fun delete(exercise: Exercise)
}