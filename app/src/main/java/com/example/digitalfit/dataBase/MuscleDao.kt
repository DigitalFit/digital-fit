package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.Equipment
import com.example.digitalfit.modelDb.Exercise
import com.example.digitalfit.modelDb.Muscle

@Dao
interface MuscleDao {
    @Query("SELECT * FROM muscle")
    suspend fun getAllMuscles(): List<Muscle>

    @Query("SELECT * FROM muscle WHERE muscleId = :muscleId")
    suspend fun loadMusclesById (muscleId: Int): List<Muscle>

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExerciseWithMuscle(): List<Muscle>

    @Transaction
    @Query("SELECT * FROM Muscle")
    fun getMuscleWithExercise(): Exercise

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMuscles (muscleList: List<Muscle>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMuscle (muscle: Muscle)

    @Delete
    suspend fun delete(muscle: Muscle)
}