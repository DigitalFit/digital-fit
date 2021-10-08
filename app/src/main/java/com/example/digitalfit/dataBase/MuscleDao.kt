package com.example.digitalfit.dataBase

import androidx.room.*
import com.example.digitalfit.modelDb.ExerciseDb
import com.example.digitalfit.modelDb.ExerciseWithMuscle
import com.example.digitalfit.modelDb.MuscleDb
import com.example.digitalfit.modelDb.MuscleWithExercise

@Dao
interface MuscleDao {
    @Query("SELECT * FROM muscle")
    suspend fun getAllMuscles(): List<MuscleDb>

    @Query("SELECT * FROM muscle WHERE muscleId = :muscleId")
    suspend fun loadMusclesById (muscleId: Int): List<MuscleDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMuscles (muscleList: List<MuscleDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMuscle (muscle: MuscleDb)

    @Delete
    suspend fun delete(muscle: MuscleDb)
}