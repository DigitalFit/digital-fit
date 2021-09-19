package com.example.digitalfit.dataBase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.digitalfit.modelDb.*

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    suspend fun getAllExercises(): Exercise

    @Query("SELECT * FROM exercise WHERE exerciseId = :exerciseId")
   suspend fun loadExerciseById (exerciseId: Int): Exercise

   @Insert(onConflict = REPLACE)
   suspend fun insertAllExercises (exercises: Exercise)

   @Insert (onConflict = REPLACE)
   suspend fun insertExercise (exercise: Exercise)

    @Delete
   suspend fun delete(exercise: Exercise)
}